package no.bouvet.sandvika.stabaek.nifs;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class NifsTransfer {
    private String type;
    private int id;
    private String uid;
    private String date;
    @Embedded
    private NifsTeam fromTeam;
    @Embedded
    private NifsTeam toTeam;
    @Embedded
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
