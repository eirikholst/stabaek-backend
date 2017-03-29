package no.bouvet.sandvika.stabaek.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PlayerStatistics {
    @Id
    private String id;
    private String stageName;
    private String stageId;
    private String teamName;
    private String teamId;
    private int goals;
    private int assists;
    private int redCards;
    private int yellowCards;

    @ManyToOne
    private Player player;

    public PlayerStatistics() {}

    public PlayerStatistics(String id, String playerId, String stageName, String stageId, String teamName, String teamId, int goals, int assists, int redCards, int yellowCards) {
        this.id = id;
        this.player = new Player(playerId, "", "", "", "", -1, "");
        this.stageName = stageName;
        this.stageId = stageId;
        this.teamName = teamName;
        this.teamId = teamId;
        this.goals = goals;
        this.assists = assists;
        this.redCards = redCards;
        this.yellowCards = yellowCards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageId() {
        return stageId;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
