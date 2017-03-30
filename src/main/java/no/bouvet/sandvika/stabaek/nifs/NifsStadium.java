package no.bouvet.sandvika.stabaek.nifs;

import java.util.Date;

public class NifsStadium {
    private String type;
    private int id;
    private String uid;
    private String name;
    private Date dateFrom;
    private Date dateTo;
    private NifsImage image;


    public NifsStadium() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public NifsImage getImage() {
        return image;
    }

    public void setImage(NifsImage image) {
        this.image = image;
    }
}
