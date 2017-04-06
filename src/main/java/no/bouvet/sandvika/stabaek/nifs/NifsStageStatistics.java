package no.bouvet.sandvika.stabaek.nifs;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class NifsStageStatistics {
    private String type;
    private int id;
    private String uid;
    @Embedded
    private NifsStage stage;
    @Embedded
    private NifsTeam team;
    private int matches;
    private int matchesStarting;
    private int matchesStartingOnBench;
    private int matchesCominOnFromBench;
    private int matchesSubstituted;
    private int minutes;
    private int goals;
    private int ownGoals;
    private int assists;
    private int indirectAssists;
    private int yellowCards;
    private int redCards;
    private int matchesWon;
    private int matchesDrawn;
    private int matchesLost;

    public NifsStageStatistics() {
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

    public NifsStage getStage() {
        return stage;
    }

    public void setStage(NifsStage stage) {
        this.stage = stage;
    }

    public NifsTeam getTeam() {
        return team;
    }

    public void setTeam(NifsTeam team) {
        this.team = team;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getMatchesStarting() {
        return matchesStarting;
    }

    public void setMatchesStarting(int matchesStarting) {
        this.matchesStarting = matchesStarting;
    }

    public int getMatchesStartingOnBench() {
        return matchesStartingOnBench;
    }

    public void setMatchesStartingOnBench(int matchesStartingOnBench) {
        this.matchesStartingOnBench = matchesStartingOnBench;
    }

    public int getMatchesCominOnFromBench() {
        return matchesCominOnFromBench;
    }

    public void setMatchesCominOnFromBench(int matchesCominOnFromBench) {
        this.matchesCominOnFromBench = matchesCominOnFromBench;
    }

    public int getMatchesSubstituted() {
        return matchesSubstituted;
    }

    public void setMatchesSubstituted(int matchesSubstituted) {
        this.matchesSubstituted = matchesSubstituted;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getOwnGoals() {
        return ownGoals;
    }

    public void setOwnGoals(int ownGoals) {
        this.ownGoals = ownGoals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getIndirectAssists() {
        return indirectAssists;
    }

    public void setIndirectAssists(int indirectAssists) {
        this.indirectAssists = indirectAssists;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getMatchesDrawn() {
        return matchesDrawn;
    }

    public void setMatchesDrawn(int matchesDrawn) {
        this.matchesDrawn = matchesDrawn;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }
}
