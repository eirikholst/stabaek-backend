package no.bouvet.sandvika.stabaek.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import no.bouvet.sandvika.stabaek.domain.team.Team;

import javax.persistence.*;
import java.util.List;

@Entity
public class Player {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String position;
    private int number;
    @ManyToOne
    @JsonBackReference
    private Team team;
//    private int teamId;
    private String teamName;
    private String profilePictureUrl;
    @Embedded
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "transfers")
    @OrderColumn
    private List<Transfer> transfers;
    @Embedded
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "playerStatistics")
    @OrderColumn
    @AttributeOverrides({
            @AttributeOverride(name = "playerId", column = @Column(name = "playerStatisticsPlayerId")),
    })
    private List<PlayerStatistics> playerStatistics;

    public Player(){}

    public Player(int id, String firstName, String lastName,
                  String position, int teamId, int number, String profilePictureUrl,
                  List<Transfer> transfers, List<PlayerStatistics> playerStatistics) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.team = new Team(teamId, "", "");
//        this.teamId = teamId;
        this.number = number;
        this.profilePictureUrl = profilePictureUrl;
        this.transfers = transfers;
        this.playerStatistics = playerStatistics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getTeamName() {
        if(team == null) return "";
        return team.getName();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

//    public int getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(int teamId) {
//        this.teamId = teamId;
//    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public List<PlayerStatistics> getPlayerStatistics() {
        return playerStatistics;
    }

    public void setPlayerStatistics(List<PlayerStatistics> playerStatistics) {
        this.playerStatistics = playerStatistics;
    }
}
