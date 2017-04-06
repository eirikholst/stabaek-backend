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
    private NifsMatch[] previousMathces;
    @Embedded
    private NifsMatch[] previousMathcesOtherTournaments;
    @Embedded
    private NifsMatch[] previousMathcesFrendlies;
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

    public NifsMatch[] getPreviousMathces() {
        return previousMathces;
    }

    public void setPreviousMathces(NifsMatch[] previousMathces) {
        this.previousMathces = previousMathces;
    }

    public NifsMatch[] getPreviousMathcesOtherTournaments() {
        return previousMathcesOtherTournaments;
    }

    public void setPreviousMathcesOtherTournaments(NifsMatch[] previousMathcesOtherTournaments) {
        this.previousMathcesOtherTournaments = previousMathcesOtherTournaments;
    }

    public NifsMatch[] getPreviousMathcesFrendlies() {
        return previousMathcesFrendlies;
    }

    public void setPreviousMathcesFrendlies(NifsMatch[] previousMathcesFrendlies) {
        this.previousMathcesFrendlies = previousMathcesFrendlies;
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
