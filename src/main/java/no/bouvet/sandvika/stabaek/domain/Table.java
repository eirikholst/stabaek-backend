package no.bouvet.sandvika.stabaek.domain;


import no.bouvet.sandvika.stabaek.domain.team.Team;
import no.bouvet.sandvika.stabaek.domain.team.TeamInTableModus;

import java.util.List;

public class Table {
    private int id;
    private List<TeamInTableModus> teams;

    public Table() {
    }

    public Table(int id, List<TeamInTableModus> teams) {
        this.id = id;
        this.teams = teams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TeamInTableModus> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamInTableModus> teams) {
        this.teams = teams;
    }
}
