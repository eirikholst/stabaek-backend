package no.bouvet.sandvika.stabaek.domain;

import no.bouvet.sandvika.stabaek.domain.team.Team;

import java.util.List;

public class HeadToHead {

    private int id;
    private List<Team> teams;
    private List<Fixture> previousFixtures;
    private List<Fixture> previousFixturesOtherTournaments;

    public HeadToHead() {
    }

    public HeadToHead(int id, List<Team> teams, List<Fixture> previousFixtures, List<Fixture> previousFixturesOtherTournaments) {
        this.id = id;
        this.teams = teams;
        this.previousFixtures = previousFixtures;
        this.previousFixturesOtherTournaments = previousFixturesOtherTournaments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Fixture> getPreviousFixtures() {
        return previousFixtures;
    }

    public void setPreviousFixtures(List<Fixture> previousFixtures) {
        this.previousFixtures = previousFixtures;
    }

    public List<Fixture> getPreviousFixturesOtherTournaments() {
        return previousFixturesOtherTournaments;
    }

    public void setPreviousFixturesOtherTournaments(List<Fixture> previousFixturesOtherTournaments) {
        this.previousFixturesOtherTournaments = previousFixturesOtherTournaments;
    }
}
