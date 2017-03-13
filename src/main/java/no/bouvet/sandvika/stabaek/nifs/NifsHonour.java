package no.bouvet.sandvika.stabaek.nifs;

public class NifsHonour {
    private String type;
    private int id;
    private String uid;
    private String name;
    private int honourTypeId;
    private NifsTournament tournament;
    private String year;
    private String title;
    private int number;
    private int stageId;

    public NifsHonour() {
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

    public int getHonourTypeId() {
        return honourTypeId;
    }

    public void setHonourTypeId(int honourTypeId) {
        this.honourTypeId = honourTypeId;
    }

    public NifsTournament getTournament() {
        return tournament;
    }

    public void setTournament(NifsTournament tournament) {
        this.tournament = tournament;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }
}
