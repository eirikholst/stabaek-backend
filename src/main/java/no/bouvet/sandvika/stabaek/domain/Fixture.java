package no.bouvet.sandvika.stabaek.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import no.bouvet.sandvika.stabaek.domain.team.Team;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class Fixture {
    @Id
    private int id;

    @ManyToOne
    @JsonBackReference
    private Team homeTeam;

    @ManyToOne
    @JsonBackReference
    private Team awayTeam;

    @ManyToOne
    @JsonBackReference
    private Stadium stadium;
//    private int stadiumId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String homeTeamNameString;

    private String homeTeamIdString;

    private String awayTeamIdString;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String awayTeamNameString;

    private String stadiumNameString;

    @Column(name = "Date")
    private Date date;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String readableDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private List<Player> homeStartXI;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private List<Player> awayStartXI;

    private int homeScore;
    private int awayScore;

    public Fixture() {
    }

    public Fixture(int id, Date date, int homeTeamId, int awayTeamId, int stadiumId){
        this.id = id;
        this.date = date;
        this.homeTeam = new Team(homeTeamId, "", "");
        this.awayTeam = new Team(awayTeamId, "" , "");
        this.stadium = new Stadium(stadiumId, "", homeTeamId, "");
//        this.stadiumId = stadiumId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return this.homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return this.awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeamNameString() {
        return this.homeTeam != null ? this.homeTeam.getName() : null;
    }

    public String getAwayTeamNameString() {
        return this.awayTeam != null ? this.awayTeam.getName() : null;
    }

    public String getStadiumNameString() {
        return this.stadium != null ? this.stadium.getName() : null;
    }

    public Stadium getStadium() {
        return this.stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReadableDate() {
        if(this.date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        return sdf.format(this.date);
    }

    public String getName() {
        return this.getHomeTeamNameString() + " - " + this.getAwayTeamNameString();
    }

    public int getAwayTeamId() {
        return this.awayTeam != null ? this.awayTeam.getId() : -1;
    }

    public int getHomeTeamId() {
        return this.homeTeam != null ? this.homeTeam.getId() : -1;
    }


    public List<Player> getHomeStartXI() {
        return homeStartXI;
    }

    public void setHomeStartXI(List<Player> homeStartXI) {
        this.homeStartXI = homeStartXI;
    }

    public List<Player> getAwayStartXI() {
        return awayStartXI;
    }

    public void setAwayStartXI(List<Player> awayStartXI) {
        this.awayStartXI = awayStartXI;
    }

//    public int getStadiumId() {
//        return stadiumId;
//    }
//
//    public void setStadiumId(int stadiumId) {
//        this.stadiumId = stadiumId;
//    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }
}
