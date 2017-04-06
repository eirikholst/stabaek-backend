package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.nifs.NifsMatch;
import no.bouvet.sandvika.stabaek.nifs.NifsPerson;
import no.bouvet.sandvika.stabaek.nifs.NifsStageStatistics;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;
import no.bouvet.sandvika.stabaek.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
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
    private PlayerStatisticsService playerStatisticsService;
    @Autowired
    private NifsService nifsService;

    @Transactional
    public void initAll() {
        try{
            initAllTransactional();
        }
        catch (ConstraintViolationException ex){
            clearAll();
            initAllTransactional();
        }
    }

    private void initAllTransactional() {
        List<NifsTeam> nifsTeams = nifsService.getAllTeamsFromEliteserien();
        this.initTeams(nifsTeams);
        this.initPlayers(nifsTeams);
        this.initStageStatistics(nifsTeams);
        this.initStadiums(nifsTeams);
        this.initFixtures();
    }

    private void clearAll() {
        this.clearFixtureDb();
        this.clearStadiumDb();
        this.clearStageStatisticsDb();
        this.clearPlayerDb();
        this.clearTeamDb();
    }

    private void clearFixtureDb() {
        this.fixtureService.clearDb();
    }

    private void clearStadiumDb() {
        this.stadiumService.clearDb();
    }

    private void clearStageStatisticsDb() {
        this.playerStatisticsService.clearDb();
    }

    private void clearPlayerDb() {
        this.playerService.clearDb();
    }

    private void clearTeamDb() {
        this.teamService.clearDb();
    }

    private void initPlayers(List<NifsTeam> nifsTeams) {
        getPlayers(nifsTeams).forEach(playerService::addPlayer);
    }

    private void initStageStatistics(List<NifsTeam> nifsTeams) {
        nifsTeams.stream()
                 .map(this::getNifsPeople)
                 .flatMap(Collection::stream)
                 .filter(Objects::nonNull)
                 .forEach(nifsPerson -> initStageStatistics(nifsPerson.getStageStatistics(), nifsPerson.getId()));
    }

    private void initStageStatistics(NifsStageStatistics[] stageStatisticsArray, int id) {
        if(stageStatisticsArray == null) return;
        Arrays.stream(stageStatisticsArray)
                .map(stageStatistics -> NifsStageStatisticsTranslator.getPlayerStatistics(stageStatistics, Integer.toString(id)))
                .filter(Objects::nonNull)
                .forEach(playerStatisticsService::addPlayerStatistics);
    }

    private void initTeams(List<NifsTeam> nifsTeams) {
        NifsTeamTranslator.getTeams(nifsTeams).forEach(teamService::addTeam);
    }

    private void initStadiums(List<NifsTeam> nifsTeams) {
        NifsStadiumTranslator.getStadiums(nifsTeams).forEach(stadiumService::addStadium);
        //Add Ullevål to team våelerenga
        stadiumService.addStadium(NifsStadiumTranslator.getStadium(nifsService.getStadium("7937"), "15"));
    }

    private void initFixtures() {
        List<NifsMatch> nifsMatches = nifsService.getAllNifsMatchesFromEliteserien();
        NifsMatchTranslator.getFixtures(nifsMatches).forEach(fixtureService::addFixture);
    }


    private List<Player> getPlayers(List<NifsTeam> nifsTeams) {
        List<String> teamIdsInEliteserien = nifsTeams.stream()
                .map(NifsTeam::getId)
                .filter(Objects::nonNull)
                .map(teamId -> Integer.toString(teamId))
                .collect(Collectors.toList());
        return nifsTeams.stream()
                .map(nifsTeam -> getNifsPeople(nifsTeam))
                .map(nifsPeople -> getPlayers(nifsPeople, teamIdsInEliteserien))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<NifsPerson> getNifsPeople(NifsTeam nifsTeam){
        return Arrays.stream(nifsTeam.getPlayers())
                .map(NifsPerson::getId)
                .map(id -> Integer.toString(id))
                .map(id -> nifsService.getPerson(id))
                .collect(Collectors.toList());
    }

    private List<Player> getPlayers(List<NifsPerson> nifsPeople, List<String> teamIdsInEliteserien) {
        return nifsPeople.stream()
                .map(nifsPerson -> NifsPlayerTranslator.getPlayerWithClubTeamInEliteserien(nifsPerson, teamIdsInEliteserien))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
