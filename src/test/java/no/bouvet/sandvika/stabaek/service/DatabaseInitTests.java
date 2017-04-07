package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.domain.Team;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseInitTests {

    @Autowired
    private AdminService adminService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;
    private Team testTeam;

    @Before
    public void initTestRuns(){
        adminService.initTest();
        testTeam = teamService.getTeam("4");
    }

    @Test
    public void teamDbContainsTestTeam(){
        Team testTeam = teamService.getTeam("4");
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
        Player testPlayer = playerService.getPlayer("434");
        Assert.notNull(testPlayer, "test player is null");

    }


}
