package no.bouvet.sandvika.stabaek.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.text.SimpleDateFormat;
import java.util.Date;

@javax.persistence.Entity
public class Fixture {
    @Id
    private String id;
    @ManyToOne
    @JsonBackReference
    @Column(name="homeTeam")
    private Team homeTeam;
    @ManyToOne
    @JsonBackReference
    @Column(name="awayTeam")
    private Team awayTeam;
    @ManyToOne
    @JsonBackReference
    @Column(name="stadium")
    private Stadium stadium;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String homeTeamNameString;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String homeTeamId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String awayTeamId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String awayTeamNameString;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String stadiumNameString;
    @Column(name = "Date")
    private Date date;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String readableDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String name;

    public Fixture() {
    }

    public Fixture(String id, Date date, String homeTeamId, String awayTeamId, String stadiumId){
        this.id = id;
        this.date = date;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        readableDate = sdf.format(date);
        this.homeTeam = new Team(homeTeamId, "");
        this.awayTeam = new Team(awayTeamId, "");
        this.stadium = new Stadium(stadiumId, "", id);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return this.homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
        if(homeTeam == null) return;
        this.homeTeamNameString = homeTeam.getName();
        this.homeTeamId = homeTeam.getId();
    }
    public Team getAwayTeam() {
        return this.awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
        if(awayTeam == null) return;
        this.awayTeamNameString = awayTeam.getName();
        this.awayTeamId = awayTeam.getId();
    }

    public String getHomeTeamNameString() {
        return this.homeTeam != null?this.homeTeam.getName():null;
    }

    public String getAwayTeamNameString() {
        return this.awayTeam != null?this.awayTeam.getName():null;
    }

    public String getStadiumNameString() {
        return this.homeTeam != null?(this.homeTeam.getStadium() != null?this.homeTeam.getStadium().getName():null):null;
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
        return readableDate;
    }

    public void setReadableDate(String readableDate) {
        this.readableDate = readableDate;
    }

    public String getName() {
        return this.getHomeTeamNameString() + " - " + this.getAwayTeamNameString();
    }

    public String getAwayTeamId() {
        return awayTeamId;
    }

    public String getHomeTeamId() {
        return homeTeamId;
    }
}
