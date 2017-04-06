package no.bouvet.sandvika.stabaek.nifs;

import javax.persistence.Embeddable;

@Embeddable
public class NifsMatchRelation {
    private String type;
    private int id;
    private String uid;
    private int winningTeamId;
    private int victoryTypeId;
    private int matchRelationTypeId;
    private int otherMatchId;
    private int aggregatedHomeGoals;
    private int aggregatedAwayGoals;
    private int aggregatedHomeGoalsExtraTime;
    private int aggregatedAwayGoalsExtraTime;

    public NifsMatchRelation() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getWinningTeamId() {
        return winningTeamId;
    }

    public void setWinningTeamId(int winningTeamId) {
        this.winningTeamId = winningTeamId;
    }

    public int getVictoryTypeId() {
        return victoryTypeId;
    }

    public void setVictoryTypeId(int victoryTypeId) {
        this.victoryTypeId = victoryTypeId;
    }

    public int getMatchRelationTypeId() {
        return matchRelationTypeId;
    }

    public void setMatchRelationTypeId(int matchRelationTypeId) {
        this.matchRelationTypeId = matchRelationTypeId;
    }

    public int getOtherMatchId() {
        return otherMatchId;
    }

    public void setOtherMatchId(int otherMatchId) {
        this.otherMatchId = otherMatchId;
    }

    public int getAggregatedHomeGoals() {
        return aggregatedHomeGoals;
    }

    public void setAggregatedHomeGoals(int aggregatedHomeGoals) {
        this.aggregatedHomeGoals = aggregatedHomeGoals;
    }

    public int getAggregatedAwayGoals() {
        return aggregatedAwayGoals;
    }

    public void setAggregatedAwayGoals(int aggregatedAwayGoals) {
        this.aggregatedAwayGoals = aggregatedAwayGoals;
    }

    public int getAggregatedHomeGoalsExtraTime() {
        return aggregatedHomeGoalsExtraTime;
    }

    public void setAggregatedHomeGoalsExtraTime(int aggregatedHomeGoalsExtraTime) {
        this.aggregatedHomeGoalsExtraTime = aggregatedHomeGoalsExtraTime;
    }

    public int getAggregatedAwayGoalsExtraTime() {
        return aggregatedAwayGoalsExtraTime;
    }

    public void setAggregatedAwayGoalsExtraTime(int aggregatedAwayGoalsExtraTime) {
        this.aggregatedAwayGoalsExtraTime = aggregatedAwayGoalsExtraTime;
    }
}
