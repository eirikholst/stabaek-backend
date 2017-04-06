package no.bouvet.sandvika.stabaek.nifs;

import javax.persistence.*;

@Embeddable
public class NifsMatchEvent {
    private String type;
    private int id;
    private String uid;
    private int matchEventTypeId;
    private int periodId;
    private boolean important;
    private int sorting;
    private int time;
    private int overtime;
    @Embedded
    private NifsTeam team;
    @Embedded
    private NifsPerson person;
    private int matchId;
    private int liveFeedId;
    @Embedded
    private NifsMatch match;
    private String score;
    @Embedded
    private NifsVideo video;

    public NifsMatchEvent() {
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

    public int getMatchEventTypeId() {
        return matchEventTypeId;
    }

    public void setMatchEventTypeId(int matchEventTypeId) {
        this.matchEventTypeId = matchEventTypeId;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public int getSorting() {
        return sorting;
    }

    public void setSorting(int sorting) {
        this.sorting = sorting;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public NifsTeam getTeam() {
        return team;
    }

    public void setTeam(NifsTeam team) {
        this.team = team;
    }

    public NifsPerson getPerson() {
        return person;
    }

    public void setPerson(NifsPerson person) {
        this.person = person;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getLiveFeedId() {
        return liveFeedId;
    }

    public void setLiveFeedId(int liveFeedId) {
        this.liveFeedId = liveFeedId;
    }

    public NifsMatch getMatch() {
        return match;
    }

    public void setMatch(NifsMatch match) {
        this.match = match;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public NifsVideo getVideo() {
        return video;
    }

    public void setVideo(NifsVideo video) {
        this.video = video;
    }
}
