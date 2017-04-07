package no.bouvet.sandvika.stabaek.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Transfer {
    private String fromTeamName;
    private String toTeamName;
    private String fromTeamId;
    private String toTeamId;
    private String date;

    public Transfer() {
    }

    public Transfer(String fromTeamName, String toTeamName, String fromTeamId, String toTeamId, String date) {
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

    public String getFromTeamId() {
        return fromTeamId;
    }

    public void setFromTeamId(String fromTeamId) {
        this.fromTeamId = fromTeamId;
    }

    public String getToTeamId() {
        return toTeamId;
    }

    public void setToTeamId(String toTeamId) {
        this.toTeamId = toTeamId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
