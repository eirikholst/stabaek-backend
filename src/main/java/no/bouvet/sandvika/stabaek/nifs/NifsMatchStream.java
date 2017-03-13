package no.bouvet.sandvika.stabaek.nifs;

/**
 * Created by eirik.holst on 10.03.2017.
 */
public class NifsMatchStream {
    private String type;
    private int id;
    private String uid;
    private String url;

    public NifsMatchStream() {
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
