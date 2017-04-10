package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.*;
import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DatabaseInitTests {

    @Autowired
    private AdminService adminService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private FixtureService fixtureService;

    private Team testTeam;
    private Player testPlayer;
    private PlayerStatistics testPlayerStatistics;
    private Fixture testFixture;

    private String stabaekId = "4";
    private String aalesundId = "46";
    private String mortenSkjoensbergId = "434";
    private String stabaekVsAalesundId = "1319283";

    @Before
    public void initTestRuns(){
        initTestDb();
        initTestTeam();
        initTestPlayer();
        initTestPlayerStatistics();
        initTestFixture();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void initTestDb() {
        adminService.initTest();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void initTestTeam() {
        testTeam = teamService.getTeam(stabaekId);
        Hibernate.initialize(testTeam.getPlayers());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void initTestPlayer() {
        testPlayer = playerService.getPlayer(mortenSkjoensbergId);
        Hibernate.initialize(testPlayer.getPlayerStatistics());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void initTestPlayerStatistics() {
        testPlayerStatistics = playerService.getPlayersStatistics(mortenSkjoensbergId, null, false).get(0);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void initTestFixture() {
        testFixture = fixtureService.getFixture(stabaekVsAalesundId);
    }

    @Test
    public void teamDbContainsTestTeam(){
        Team testTeam = teamService.getTeam(stabaekId);
        Assert.notNull(testTeam, "test team is null");
    }

    @Test
    public void testTeamHasPlayers(){
        Assert.notNull(testTeam, "test team is null");
        Assert.notNull(testTeam.getPlayers(), "test team player list is null");
        Assert.notEmpty(testTeam.getPlayers(), "test team player list is empty");
    }

    @Test
    public void playerDbContainsTestPlayer(){
        Player testPlayer = playerService.getPlayer(mortenSkjoensbergId);
        Assert.notNull(testPlayer, "test player is null");
    }

    @Test
    public void testPlayerNumberIsGreaterThanZero(){
        Assert.notNull(testPlayer, "test player is null");
        assertThat(testPlayer.getNumber()).isGreaterThan(0);
    }

    @Test
    public void testPlayerHasTransfers(){
        Assert.notNull(testPlayer, "test player is null");
        Assert.notNull(testPlayer, "test player transfer list is null");
        Assert.notEmpty(testPlayer.getTransfers(), "test player transfer list is empty");
    }

    @Test
    public void testPlayerHasPlayerStatistics(){
        Assert.notNull(testPlayer, "test player is null");
        Assert.notNull(testPlayer, "test player playerStatistics list is null");
        Assert.notEmpty(testPlayer.getPlayerStatistics(), "test player playerStatistics list is empty");
    }

    @Test
    public void testPlayerStatisticsHasPlayerName(){
        Assert.notNull(testPlayerStatistics, "test playerStatistics is null");
        Assert.notNull(testPlayerStatistics.getPlayerName(), "test playerStatistics playerName is null");
        assertThat(testPlayerStatistics.getPlayerName()).isNotEmpty();
    }

    @Test
    public void testFixtureIsNotNull(){
        Fixture fixture = fixtureService.getFixture(stabaekVsAalesundId);
        Assert.notNull(fixture, "test fixture is null");
    }

    @Test
    public void testFixtureHasHeadToHead(){
        HeadToHead headToHead = fixtureService.getHeadToHead(stabaekVsAalesundId);
        Assert.notNull(headToHead, "test headToHead is null");
    }

}
