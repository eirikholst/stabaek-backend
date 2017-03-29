package no.bouvet.sandvika.stabaek.nifs;

import java.lang.reflect.Array;
import java.util.Date;

public class NifsStage {
    private String type;
    private int id;
    private String uid;
    private String name;
    private String fullName;
    private String groupName;
    private int startYear;
    private int endYear;
    private Date startDate;
    private Date endDate;
    private int stageTypeId;
    private NifsTournament tournament;
    private Array data;
    private int visibilityId;
    private String comment;
    private NifsTeam[] teams;
    private NifsName[] names;

    public NifsStage() {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getStageTypeId() {
        return stageTypeId;
    }

    public void setStageTypeId(int stageTypeId) {
        this.stageTypeId = stageTypeId;
    }

    public NifsTournament getTournament() {
        return tournament;
    }

    public void setTournament(NifsTournament tournament) {
        this.tournament = tournament;
    }

    public Array getData() {
        return data;
    }

    public void setData(Array data) {
        this.data = data;
    }

    public int getVisibilityId() {
        return visibilityId;
    }

    public void setVisibilityId(int visibilityId) {
        this.visibilityId = visibilityId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public NifsTeam[] getTeams() {
        return teams;
    }

    public void setTeams(NifsTeam[] teams) {
        this.teams = teams;
    }

    public NifsName[] getNames() {
        return names;
    }

    public void setNames(NifsName[] names) {
        this.names = names;
    }
}
