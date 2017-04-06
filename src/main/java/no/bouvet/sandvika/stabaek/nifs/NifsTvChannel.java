package no.bouvet.sandvika.stabaek.nifs;

import javax.persistence.Embeddable;

@Embeddable
public class NifsTvChannel {
    private String type;
    private int id;
    private String uid;
    private String url;

    public NifsTvChannel() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
