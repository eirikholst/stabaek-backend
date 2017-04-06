package no.bouvet.sandvika.stabaek.nifs;

import javax.persistence.*;
import java.util.Date;

@Embeddable
public class NifsMatch {
    private String type;
    private int id;
    private String uid;
    private String name;
    private Date timestamp;
    private int matchStatusId;
    private int matchTypeId;
    private int round;
    private int attendance;
    @Embedded
    private NifsResult result;
    @Embedded
    private NifsStadium stadium;
    @Embedded
    private NifsTeam homeTeam;
    @Embedded
    private NifsTeam awayTeam;
    @Embedded
    private NifsStage stage;
    private int stageId;
    @Embedded
    private NifsPerson[] referees;
    @Embedded
    private NifsMatchEvent[] matchEvents;
    @Embedded
    private NifsLiveFeed[] liveFeeds;
    private String comment;
    private int[] tv2Ids;
    private int enetpulseId;
    private boolean isLineupConfirmed;
    private boolean coveredLive;
    @Embedded
    private NifsMatchRelation relation;
    @Embedded
    private NifsMatchStatistics matchStatistics;
    private Date timeStartFirstHalf;
    private Date timeStartSecondHalf;
    private Date timeStartFirstHalfExtraTime;
    private Date timeStartSecondHalfExtraTime;
    @Embedded
    private NifsMatchStream[] matchStreams;
    @Embedded
    private NifsVideo matchHighlightVideo;
    @Embedded
    private NifsTvChannel[] tvChannels;

    public NifsMatch() {
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getMatchStatusId() {
        return matchStatusId;
    }

    public void setMatchStatusId(int matchStatusId) {
        this.matchStatusId = matchStatusId;
    }

    public int getMatchTypeId() {
        return matchTypeId;
    }

    public void setMatchTypeId(int matchTypeId) {
        this.matchTypeId = matchTypeId;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public NifsResult getResult() {
        return result;
    }

    public void setResult(NifsResult result) {
        this.result = result;
    }

    public NifsStadium getStadium() {
        return stadium;
    }

    public void setStadium(NifsStadium stadium) {
        this.stadium = stadium;
    }

    public NifsTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(NifsTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public NifsTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(NifsTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public NifsStage getStage() {
        return stage;
    }

    public void setStage(NifsStage stage) {
        this.stage = stage;
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public NifsPerson[] getReferees() {
        return referees;
    }

    public void setReferees(NifsPerson[] referees) {
        this.referees = referees;
    }

    public NifsMatchEvent[] getMatchEvents() {
        return matchEvents;
    }

    public void setMatchEvents(NifsMatchEvent[] matchEvents) {
        this.matchEvents = matchEvents;
    }

    public NifsLiveFeed[] getLiveFeeds() {
        return liveFeeds;
    }

    public void setLiveFeeds(NifsLiveFeed[] liveFeeds) {
        this.liveFeeds = liveFeeds;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int[] getTv2Ids() {
        return tv2Ids;
    }

    public void setTv2Ids(int[] tv2Ids) {
        this.tv2Ids = tv2Ids;
    }

    public int getEnetpulseId() {
        return enetpulseId;
    }

    public void setEnetpulseId(int enetpulseId) {
        this.enetpulseId = enetpulseId;
    }

    public boolean isLineupConfirmed() {
        return isLineupConfirmed;
    }

    public void setLineupConfirmed(boolean lineupConfirmed) {
        isLineupConfirmed = lineupConfirmed;
    }

    public boolean isCoveredLive() {
        return coveredLive;
    }

    public void setCoveredLive(boolean coveredLive) {
        this.coveredLive = coveredLive;
    }

    public NifsMatchRelation getRelation() {
        return relation;
    }

    public void setRelation(NifsMatchRelation relation) {
        this.relation = relation;
    }

    public NifsMatchStatistics getMatchStatistics() {
        return matchStatistics;
    }

    public void setMatchStatistics(NifsMatchStatistics matchStatistics) {
        this.matchStatistics = matchStatistics;
    }

    public Date getTimeStartFirstHalf() {
        return timeStartFirstHalf;
    }

    public void setTimeStartFirstHalf(Date timeStartFirstHalf) {
        this.timeStartFirstHalf = timeStartFirstHalf;
    }

    public Date getTimeStartSecondHalf() {
        return timeStartSecondHalf;
    }

    public void setTimeStartSecondHalf(Date timeStartSecondHalf) {
        this.timeStartSecondHalf = timeStartSecondHalf;
    }

    public Date getTimeStartFirstHalfExtraTime() {
        return timeStartFirstHalfExtraTime;
    }

    public void setTimeStartFirstHalfExtraTime(Date timeStartFirstHalfExtraTime) {
        this.timeStartFirstHalfExtraTime = timeStartFirstHalfExtraTime;
    }

    public Date getTimeStartSecondHalfExtraTime() {
        return timeStartSecondHalfExtraTime;
    }

    public void setTimeStartSecondHalfExtraTime(Date timeStartSecondHalfExtraTime) {
        this.timeStartSecondHalfExtraTime = timeStartSecondHalfExtraTime;
    }

    public NifsMatchStream[] getMatchStreams() {
        return matchStreams;
    }

    public void setMatchStreams(NifsMatchStream[] matchStreams) {
        this.matchStreams = matchStreams;
    }

    public NifsVideo getMatchHighlightVideo() {
        return matchHighlightVideo;
    }

    public void setMatchHighlightVideo(NifsVideo matchHighlightVideo) {
        this.matchHighlightVideo = matchHighlightVideo;
    }

    public NifsTvChannel[] getTvChannels() {
        return tvChannels;
    }

    public void setTvChannels(NifsTvChannel[] tvChannels) {
        this.tvChannels = tvChannels;
    }
}
