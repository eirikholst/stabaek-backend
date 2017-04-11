package no.bouvet.sandvika.stabaek.domain;


import no.bouvet.sandvika.stabaek.domain.team.Team;
import no.bouvet.sandvika.stabaek.domain.team.TeamInTableModus;

import java.util.List;

public class Table {
    private String id;
    private List<TeamInTableModus> teams;

    public Table() {
    }

    public Table(String id, List<TeamInTableModus> teams) {
        this.id = id;
        this.teams = teams;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TeamInTableModus> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamInTableModus> teams) {
        this.teams = teams;
    }
}
