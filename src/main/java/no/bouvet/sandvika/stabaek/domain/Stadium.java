package no.bouvet.sandvika.stabaek.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import no.bouvet.sandvika.stabaek.domain.Fixture;
import no.bouvet.sandvika.stabaek.domain.Team;

@Entity
public class Stadium {
    @Id
    private String id;
    private String name;
    @OneToOne(
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

    public Stadium() {
    }

    public Stadium(String id, String name, String teamId) {
        this.id = id;
        this.name = name;
        this.team = new Team(teamId, "", "");
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
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
}
