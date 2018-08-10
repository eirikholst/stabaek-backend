package no.bouvet.sandvika.stabaek.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.*;

import no.bouvet.sandvika.stabaek.domain.team.Team;

@Entity
public class Stadium {
    @Id
    private int id;
    private String name;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JsonBackReference
    private Team team;
    @OneToMany(
            mappedBy = "stadium"
    )
    @JsonManagedReference
    private List<Fixture> fixtures;
    private String teamNameString;
    private String stadiumImageUrl;

    public Stadium() {
    }

    public Stadium(int id, String name, int teamId, String stadiumImageUrl) {
        this.id = id;
        this.name = name;
        this.team = new Team(teamId, "", "");
        this.stadiumImageUrl = stadiumImageUrl;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getTeamNameString() {
        return this.team != null?this.team.getName():null;
    }

    public List<Fixture> getFixtures() {
        return this.fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

    public String getStadiumImageUrl() {
        return stadiumImageUrl;
    }

    public void setStadiumImageUrl(String stadiumImageUrl) {
        this.stadiumImageUrl = stadiumImageUrl;
    }
}
