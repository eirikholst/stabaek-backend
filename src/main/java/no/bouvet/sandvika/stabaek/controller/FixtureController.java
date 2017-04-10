package no.bouvet.sandvika.stabaek.controller;

import java.util.List;
import no.bouvet.sandvika.stabaek.domain.Fixture;
import no.bouvet.sandvika.stabaek.domain.HeadToHead;
import no.bouvet.sandvika.stabaek.service.FixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FixtureController {
    @Autowired
    private FixtureService fixtureService;

    public FixtureController() {
    }

    @CrossOrigin
    @RequestMapping({"/fixtures"})
    public List<Fixture> getAllFixtures() {
        return this.fixtureService.getAllFixtures();
    }

    @CrossOrigin
    @RequestMapping({"/fixtures/findByHomeTeam={homeTeam}"})
    public List<Fixture> getFixturesByHomeTeam(@PathVariable("homeTeam") String homeTeam) {
        return this.fixtureService.getFixturesByHomeTeam(homeTeam);
    }

    @CrossOrigin
    @RequestMapping({"/fixtures/findByAwayTeam={awayTeam}"})
    public List<Fixture> getFixturesByAwayTeam(@PathVariable("awayTeam") String awayTeam) {
        return this.fixtureService.getFixturesByAwayTeam(awayTeam);
    }

    @CrossOrigin
    @RequestMapping({"/fixtures/findByStadium={stadium}"})
    public List<Fixture> getFixturesByStadium(@PathVariable("stadium") String stadium) {
        return this.fixtureService.getFixturesByStadium(stadium);
    }

    @CrossOrigin
    @RequestMapping({"/fixtures/findByTeam={team}"})
    public List<Fixture> getFixtureByTeam(@PathVariable("team") String team){
        return this.fixtureService.getFixturesByTeam(team);
    }

    @CrossOrigin
    @RequestMapping({"/fixtures/{id}"})
    public Fixture getFixture(@PathVariable("id") String id){
        return this.fixtureService.getFixture(id);
    }


    @CrossOrigin
    @RequestMapping({"/fixtures/{id}/headToHead"})
    public HeadToHead getHeadToHead(@PathVariable("id") String id){
        return this.fixtureService.getHeadToHead(id);
    }

}
