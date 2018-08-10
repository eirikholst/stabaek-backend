package no.bouvet.sandvika.stabaek.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Transfer {
    private String fromTeamName;
    private String toTeamName;
    private int fromTeamId;
    private int toTeamId;
    private String date;

    public Transfer() {
    }

    public Transfer(String fromTeamName, String toTeamName, int fromTeamId, int toTeamId, String date) {
        this.fromTeamName = fromTeamName;
        this.toTeamName = toTeamName;
        this.fromTeamId = fromTeamId;
        this.toTeamId = toTeamId;
        this.date = date;
    }

    public String getFromTeamName() {
        return fromTeamName;
    }

    public void setFromTeamName(String fromTeamName) {
        this.fromTeamName = fromTeamName;
    }

    public String getToTeamName() {
        return toTeamName;
    }

    public void setToTeamName(String toTeamName) {
        this.toTeamName = toTeamName;
    }

    public int getFromTeamId() {
        return fromTeamId;
    }

    public void setFromTeamId(int fromTeamId) {
        this.fromTeamId = fromTeamId;
    }

    public int getToTeamId() {
        return toTeamId;
    }

    public void setToTeamId(int toTeamId) {
        this.toTeamId = toTeamId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
