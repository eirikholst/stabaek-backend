package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.domain.Team;
import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseInitTests {

//    @Autowired
//    private AdminService adminService;
//    @Autowired
//    private TeamService teamService;
//    @Autowired
//    private PlayerService playerService;
//    private Team testTeam;
//    private Player testPlayer;
//
//    @Before
//    public void initTestRuns(){
//        adminService.initTest();
//        testTeam = teamService.getTeam("4");
//        testPlayer = playerService.getPlayer("434");
//    }
//
//    @Test
//    public void teamDbContainsTestTeam(){
//        Team testTeam = teamService.getTeam("4");
//        Assert.notNull(testTeam, "test team is null");
//    }
//
//    @Test
//    public void testTeamHasPlayers(){
//        Assert.notNull(testTeam, "test team is null");
//        Hibernate.initialize(testTeam.getPlayers());
//        Assert.notNull(testTeam.getPlayers(), "test team player list is null");
//        Assert.notEmpty(testTeam.getPlayers(), "test team player list is empty");
//    }
//
//    @Test
//    public void playerDbContainsTestPlayer(){
//        Player testPlayer = playerService.getPlayer("434");
//        Assert.notNull(testPlayer, "test player is null");
//    }
//
//    @Test
//    public void testPlayerNumberIsGreaterThanZero(){
//        Assert.notNull(testPlayer, "test player is null");
//        assertThat(testPlayer.getNumber()).isGreaterThan(0);
//    }
//
//    @Test
//    public void testPlayerHasTransfers(){
//        Assert.notNull(testPlayer, "test player is null");
//        Assert.notNull(testPlayer, "test player transfer list is null");
//        Assert.notEmpty(testPlayer.getTransfers(), "test player transfer list is empty");
//    }
//
//    @Test
//    public void testPlayerHasPlayerStatistics(){
//        Assert.notNull(testPlayer, "test player is null");
//        Assert.notNull(testPlayer, "test player playerStatistics list is null");
//        Assert.notEmpty(testPlayer.getPlayerStatistics(), "test player playerStatistics list is empty");
//    }


}
