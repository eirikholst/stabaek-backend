package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.Fixture;
import no.bouvet.sandvika.stabaek.domain.HeadToHead;
import no.bouvet.sandvika.stabaek.repository.FixtureRepository;
import no.bouvet.sandvika.stabaek.utils.NifsHeadToHeadTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FixtureService implements ClearableService{

    @Autowired
    private FixtureRepository fixtureRepository;
    @Autowired
    private NifsService nifsService;

    public FixtureService() {
    }

    public List<Fixture> getAllFixtures() {
        ArrayList fixtures = new ArrayList();
        this.fixtureRepository.findAll().forEach(fixtures::add);
        return fixtures;
    }

    public void addFixture(Fixture fixture) {
        this.fixtureRepository.save(fixture);
    }

    public List<Fixture> getFixturesByHomeTeam(String homeTeam) {
        return this.fixtureRepository.findByHomeTeamName(homeTeam);
    }

    public List<Fixture> getFixturesByAwayTeam(String awayTeam) {
        return this.fixtureRepository.findByAwayTeamName(awayTeam);
    }

    public List<Fixture> getFixturesByStadium(String stadium) {
        return this.fixtureRepository.findByStadiumName(stadium);
    }

    public List<Fixture> getFixturesByTeam(String team) {
        List<Fixture> fixtures = getFixturesByHomeTeam(team);
        fixtures.addAll(getFixturesByAwayTeam(team));
        return fixtures;
    }

    public Fixture getFixture(String id) {
        return fixtureRepository.findById(id).orElse(null);
    }

    public void clearDb() {
        this.fixtureRepository.deleteAll();
    }

    public HeadToHead getHeadToHead(String id) {
        return NifsHeadToHeadTranslator.getHeadToHead(nifsService.getHeadToHead(id));
    }
}
