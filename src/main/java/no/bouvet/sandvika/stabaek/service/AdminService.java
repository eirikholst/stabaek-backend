package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.nifs.NifsMatch;
import no.bouvet.sandvika.stabaek.nifs.NifsPerson;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;
import no.bouvet.sandvika.stabaek.utils.NifsMatchTranslator;
import no.bouvet.sandvika.stabaek.utils.NifsPlayerTranslator;
import no.bouvet.sandvika.stabaek.utils.NifsStadiumTranslator;
import no.bouvet.sandvika.stabaek.utils.NifsTeamTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AdminService {
    
    @Autowired
    private FixtureService fixtureService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private StadiumService stadiumService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private NifsService nifsService;
    
    public void init() {
        List<NifsTeam> nifsTeams = nifsService.getAllTeamsFromEliteserien();
        this.InitTeams(nifsTeams);
        this.InitPlayers(nifsTeams);
        this.InitStadiums(nifsTeams);
        this.InitFixtures();
    }

    private void InitPlayers(List<NifsTeam> nifsTeams) {
        getPlayers(nifsTeams).forEach(playerService::addPlayer);
    }

    private void InitTeams(List<NifsTeam> nifsTeams) {
        NifsTeamTranslator.getTeams(nifsTeams).forEach(teamService::addTeam);
    }

    private void InitStadiums(List<NifsTeam> nifsTeams) {
        NifsStadiumTranslator.getStadiums(nifsTeams).forEach(stadiumService::addStadium);
    }

    private void InitFixtures() {
        List<NifsMatch> nifsMatches = nifsService.getAllNifsMatchesFromEliteserien();
        NifsMatchTranslator.getFixtures(nifsMatches).forEach(fixtureService::addFixture);
    }

    private List<Player> getPlayers(List<NifsTeam> nifsTeams) {
        List<String> teamIdsInEliteserien = nifsTeams.stream()
                .map(team -> team.getId())
                .filter(Objects::nonNull)
                .map(teamId -> Integer.toString(teamId))
                .collect(Collectors.toList());
        return nifsTeams.stream()
                .map(nifsTeam -> getPlayers(nifsTeam, teamIdsInEliteserien))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<Player> getPlayers(NifsTeam nifsTeam, List<String> teamIdsInEliteserien) {

        return Arrays.stream(nifsTeam.getPlayers())
                .map(NifsPerson::getId)
                .map(id -> Integer.toString(id))
                .map(id -> nifsService.getPerson(id))
                .map(nifsPerson -> NifsPlayerTranslator.getPlayer(nifsPerson, teamIdsInEliteserien))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());


    }
}
