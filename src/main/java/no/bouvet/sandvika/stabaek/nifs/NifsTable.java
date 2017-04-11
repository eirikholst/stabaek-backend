package no.bouvet.sandvika.stabaek.nifs;

public class NifsTable {
    private String type;
    private int id;
    private String uid;
    private String tableType;
    private NifsStage stage;
    private NifsTableDividingLine[] nifsTableDividingLines;
    private NifsTeam[] teams;

    public NifsTable() {
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

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public NifsStage getStage() {
        return stage;
    }

    public void setStage(NifsStage stage) {
        this.stage = stage;
    }

    public NifsTableDividingLine[] getNifsTableDividingLines() {
        return nifsTableDividingLines;
    }

    public void setNifsTableDividingLines(NifsTableDividingLine[] nifsTableDividingLines) {
        this.nifsTableDividingLines = nifsTableDividingLines;
    }

    public NifsTeam[] getTeams() {
        return teams;
    }

    public void setTeams(NifsTeam[] teams) {
        this.teams = teams;
    }
}
