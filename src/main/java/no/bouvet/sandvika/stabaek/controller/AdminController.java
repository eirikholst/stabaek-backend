package no.bouvet.sandvika.stabaek.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import no.bouvet.sandvika.stabaek.nifs.NifsMatch;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;
import no.bouvet.sandvika.stabaek.service.FixtureService;
import no.bouvet.sandvika.stabaek.service.StadiumService;
import no.bouvet.sandvika.stabaek.service.TeamService;
import no.bouvet.sandvika.stabaek.utils.NifsMatchTranslator;
import no.bouvet.sandvika.stabaek.utils.NifsStadiumTranslator;
import no.bouvet.sandvika.stabaek.utils.NifsTeamTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AdminController {
    @Autowired
    private FixtureService fixtureService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private StadiumService stadiumService;

    public AdminController() {
    }

    @CrossOrigin
    @RequestMapping({"/admin/init"})
    public void init() {
        this.InitTeams();
        this.InitStadiums();
        this.InitFixtures();
    }

    private void InitTeams() {
        RestTemplate restTemplate = new RestTemplate();
        NifsTeam[] nifsTeams = restTemplate.getForObject("https://api.nifs.no/countries/1/tournaments/5/stages/673879/teams", NifsTeam[].class, new Object[0]);
        NifsTeamTranslator.getTeams(nifsTeams).forEach(teamService::addTeam);
    }

    private void InitStadiums() {
        RestTemplate restTemplate = new RestTemplate();
        NifsTeam[] nifsTeams = restTemplate.getForObject("https://api.nifs.no/countries/1/tournaments/5/stages/673879/teams", NifsTeam[].class, new Object[0]);
        NifsStadiumTranslator.getStadiums(nifsTeams).forEach(stadiumService::addStadium);
    }

    private void InitFixtures() {
        RestTemplate restTemplate = new RestTemplate();
        NifsMatch[] nifsMatches = (NifsMatch[])restTemplate.getForObject("https://api.nifs.no/countries/1/tournaments/5/stages/673879/matches", NifsMatch[].class, new Object[0]);
        NifsMatchTranslator.getFixtures(nifsMatches).forEach(fixtureService::addFixture);
    }
}
