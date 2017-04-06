package no.bouvet.sandvika.stabaek.nifs;

import javax.persistence.Embeddable;

@Embeddable
public class NifsKit {
    private String type;
    private int id;
    private String uid;
    private String[] colorCodes;
    private int kitTypeId;
    private int petternId;
    private String numberColor;

    public NifsKit() {
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

    public String[] getColorCodes() {
        return colorCodes;
    }

    public void setColorCodes(String[] colorCodes) {
        this.colorCodes = colorCodes;
    }

    public int getKitTypeId() {
        return kitTypeId;
    }

    public void setKitTypeId(int kitTypeId) {
        this.kitTypeId = kitTypeId;
    }

    public int getPetternId() {
        return petternId;
    }

    public void setPetternId(int petternId) {
        this.petternId = petternId;
    }

    public String getNumberColor() {
        return numberColor;
    }

    public void setNumberColor(String numberColor) {
        this.numberColor = numberColor;
    }
}
