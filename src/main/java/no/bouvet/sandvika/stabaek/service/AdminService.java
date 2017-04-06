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
    private PlayerStatisticsService playerStatisticsService;
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
        this.initStageStatistics();
        this.initStadiums();
        this.initFixtures();
    }

    public void clearAll() {
        this.clearFixtureDb();
        this.clearStadiumDb();
        this.clearStageStatisticsDb();
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

    public void updateStageStatistics() {
        this.initStageStatistics();
    }

    public void updateStadiums() {
        this.initStadiums();
    }

    public void updateFixtures() {
        this.initFixtures();
    }

    private void clearNifsTeamDb(){
        this.nifsTeamService.clearDb();
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

    private void initNifsTeams() {
        nifsService.getAllTeamsFromEliteserien().forEach(nifsTeamService::addTeam);
    }

    private void initPlayers() {
        getPlayers().forEach(playerService::addPlayer);
    }

    private void initStageStatistics() {
        getAllNifsTeams().stream()
                .map(this::getNifsPeople)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .forEach(nifsPerson -> initStageStatistics(nifsPerson.getStageStatistics(), nifsPerson.getId()));
    }

    private void initStageStatistics(NifsStageStatistics[] stageStatisticsArray, int id) {
        if (stageStatisticsArray == null) return;
        Arrays.stream(stageStatisticsArray)
                .map(stageStatistics -> NifsStageStatisticsTranslator.getPlayerStatistics(stageStatistics, Integer.toString(id)))
                .filter(Objects::nonNull)
                .forEach(playerStatisticsService::addPlayerStatistics);
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
        return getAllNifsTeams().stream()
                .map(nifsTeam -> NifsPlayerTranslator.getPlayers(nifsTeam))
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private List<NifsTeam> getAllNifsTeams() {
        List<NifsTeam> nifsTeams = nifsTeamService.getAllNifsTeams();
        if (nifsTeams == null || nifsTeams.size() == 0)
            initNifsTeams();
        if (nifsTeams == null || nifsTeams.size() == 0)
            throw new RuntimeException("Could not get Nifs teams! Check REST API call 'https://api.nifs.no/countries/1/tournaments/5/stages/673879/teams'");
        return nifsTeams;
    }

    private List<NifsPerson> getNifsPeople(NifsTeam nifsTeam) {
        return Arrays.stream(nifsTeam.getPlayers())
                .map(NifsPerson::getId)
                .map(id -> Integer.toString(id))
                .map(id -> nifsService.getPerson(id))
                .collect(Collectors.toList());
    }
}
