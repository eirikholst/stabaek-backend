package no.bouvet.sandvika.stabaek.nifs;

import javax.persistence.Embeddable;

@Embeddable
public class NifsVideo {
    private String type;
    private int id;
    private String uid;
    private String source;
    private String lemonwhaleId;

    public NifsVideo() {
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLemonwhaleId() {
        return lemonwhaleId;
    }

    public void setLemonwhaleId(String lemonwhaleId) {
        this.lemonwhaleId = lemonwhaleId;
    }
}
