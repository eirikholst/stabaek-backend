package no.bouvet.sandvika.stabaek.nifs;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class NifsHeadToHead {
    private String type;
    private int id;
    private String uid;
    @Embedded
    private NifsTeam[] teams;
    @Embedded
    private NifsMatch[] previousMatches;
    @Embedded
    private NifsMatch[] previousMatchesFriendlies;
    @Embedded
    private NifsMatch[] previousMatchesOtherTournaments;
    private String tournamentName;
    private String fromSeason;

    public NifsHeadToHead() {
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

    public NifsTeam[] getTeams() {
        return teams;
    }

    public void setTeams(NifsTeam[] teams) {
        this.teams = teams;
    }

    public NifsMatch[] getPreviousMatches() {
        return previousMatches;
    }

    public void setPreviousMatches(NifsMatch[] previousMatches) {
        this.previousMatches = previousMatches;
    }

    public NifsMatch[] getPreviousMatchesOtherTournaments() {
        return previousMatchesOtherTournaments;
    }

    public void setPreviousMatchesOtherTournaments(NifsMatch[] previousMatchesOtherTournaments) {
        this.previousMatchesOtherTournaments = previousMatchesOtherTournaments;
    }

    public NifsMatch[] getPreviousMatchesFrendlies() {
        return previousMatchesFriendlies;
    }

    public void setPreviousMatchesFrendlies(NifsMatch[] previousMatchesFrendlies) {
        this.previousMatchesFriendlies = previousMatchesFrendlies;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getFromSeason() {
        return fromSeason;
    }

    public void setFromSeason(String fromSeason) {
        this.fromSeason = fromSeason;
    }
}
