package no.bouvet.sandvika.stabaek.nifs;

import java.util.Date;

public class NifsTransfer {
    private String type;
    private int id;
    private String uid;
    private Date date;
    private NifsTeam fromTeam;
    private NifsTeam toTeam;
    private NifsPerson person;

    public NifsTransfer() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public NifsTeam getFromTeam() {
        return fromTeam;
    }

    public void setFromTeam(NifsTeam fromTeam) {
        this.fromTeam = fromTeam;
    }

    public NifsTeam getToTeam() {
        return toTeam;
    }

    public void setToTeam(NifsTeam toTeam) {
        this.toTeam = toTeam;
    }

    public NifsPerson getPerson() {
        return person;
    }

    public void setPerson(NifsPerson person) {
        this.person = person;
    }
}
