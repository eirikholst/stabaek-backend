package no.bouvet.sandvika.stabaek.nifs;

public class NifsTableDividingLine {
    private String type;
    private int id;
    private String uid;
    private int fromPlace;
    private int toPlace;
    private int typeId;

    public NifsTableDividingLine() {
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

    public int getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(int fromPlace) {
        this.fromPlace = fromPlace;
    }

    public int getToPlace() {
        return toPlace;
    }

    public void setToPlace(int toPlace) {
        this.toPlace = toPlace;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
