package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.nifs.NifsMatch;
import no.bouvet.sandvika.stabaek.nifs.NifsPerson;
import no.bouvet.sandvika.stabaek.nifs.NifsStageStatistics;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;
import no.bouvet.sandvika.stabaek.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private NifsTeamService nifsTeamService;
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

    @Transactional
    public void initAll() {
        try {
            initAllTransactional();
        } catch (ConstraintViolationException ex) {
            clearAll();
            initAllTransactional();
        }
    }

    private void initAllTransactional() {
        this.initNifsTeams();
        this.initTeams();
        this.initPlayers();
        this.initStadiums();
        this.initFixtures();
    }

    public void clearAll() {
        this.clearFixtureDb();
        this.clearStadiumDb();
        this.clearPlayerDb();
        this.clearTeamDb();
        this.clearNifsTeamDb();
    }

    public void updateTeams() {
        this.initTeams();
    }

    public void updatePlayers() {
        this.initPlayers();
    }

    public void updateStadiums() {
        this.initStadiums();
    }

    public void updateFixtures() {
        this.initFixtures();
    }

    private void clearNifsTeamDb() {
        this.nifsTeamService.clearDb();
    }

    private void clearFixtureDb() {
        this.fixtureService.clearDb();
    }

    private void clearStadiumDb() {
        this.stadiumService.clearDb();
    }

    private void clearPlayerDb() {
        this.playerService.clearDb();
    }

    private void clearTeamDb() {
        this.teamService.clearDb();
    }

    public void initNifsTeams() {
        nifsService.getAllTeamsFromEliteserien().forEach(nifsTeamService::addTeam);
    }

    private void initPlayers() {
        getPlayers().forEach(playerService::addPlayer);
    }

    private void initTeams() {
        NifsTeamTranslator.getTeams(getAllNifsTeams()).forEach(teamService::addTeam);
    }

    private void initStadiums() {
        NifsStadiumTranslator.getStadiums(getAllNifsTeams()).forEach(stadiumService::addStadium);
        //Add Ullevål to team våelerenga
        stadiumService.addStadium(NifsStadiumTranslator.getStadium(nifsService.getStadium("7937"), "15"));
    }

    private void initFixtures() {
        List<NifsMatch> nifsMatches = nifsService.getAllNifsMatchesFromEliteserien();
        NifsMatchTranslator.getFixtures(nifsMatches).forEach(fixtureService::addFixture);
    }


    private List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        getAllNifsTeams().forEach(nifsTeam ->
                getNifsPeople(nifsTeam).forEach(nifsPerson ->
                        players.add(NifsPlayerTranslator.getPlayer(nifsPerson, nifsTeam))));
        return players;
    }

    public List<NifsTeam> getAllNifsTeams() {
        List<NifsTeam> nifsTeams = nifsTeamService.getAllNifsTeams();
        if (nifsTeams == null || nifsTeams.size() == 0) {
            initNifsTeams();
            nifsTeams = nifsTeamService.getAllNifsTeams();
        }
        if (nifsTeams == null || nifsTeams.size() == 0)
            throw new RuntimeException("Could not get Nifs teams! Check REST API call 'https://api.nifs.no/countries/1/tournaments/5/stages/673879/teams'");
        return nifsTeams;
    }

    private List<NifsPerson> getNifsPeople(NifsTeam nifsTeam) {
        return nifsTeam.getPlayers().stream()
                .map(NifsPerson::getId)
                .map(id -> Integer.toString(id))
                .map(id -> nifsService.getPerson(id))
                .collect(Collectors.toList());
    }

    private List<NifsPerson> getAllCompleteNifsPeople() {
        return getAllNifsTeams().stream()
                .map(this::getNifsPeople)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private List<NifsPerson> getCompactNifsPeople() {
        return getAllNifsTeams().stream()
                .map(NifsTeam::getPlayers)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void initTest() {
        NifsTeam stabaekNifsTeam = nifsService.getNifsTeam(4);
        NifsTeam aalesundNifsTeam = nifsService.getNifsTeam(46);

        //team
        teamService.addTeam(NifsTeamTranslator.getTeam(stabaekNifsTeam));
        teamService.addTeam(NifsTeamTranslator.getTeam(aalesundNifsTeam));

        //players
        getNifsPeople(stabaekNifsTeam).stream()
            .map(nifsPerson -> NifsPlayerTranslator.getPlayer(nifsPerson, stabaekNifsTeam))
            .forEach(playerService::addPlayer);

        //stadium
        stadiumService.addStadium(NifsStadiumTranslator.getStadium(stabaekNifsTeam));

        //fixtures
        fixtureService.addFixture(NifsMatchTranslator.getFixture(nifsService.getNifsMatch(1319283)));
    }
}
