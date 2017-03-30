package no.bouvet.sandvika.stabaek.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@javax.persistence.Entity
public class Fixture {
    @Id
    private String id;

    @ManyToOne
    @JsonBackReference
    private Team homeTeam;

    @ManyToOne
    @JsonBackReference
    private Team awayTeam;

    @ManyToOne
    @JsonBackReference
    private Stadium stadium;

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

    public Fixture() {
    }

    public Fixture(String id, Date date, String homeTeamId, String awayTeamId, String stadiumId, List<Player> homeStartXI, List<Player> awayStartXI){
        this(id, date, homeTeamId, awayTeamId, stadiumId);
        this.homeStartXI = homeStartXI;
        this.awayStartXI = awayStartXI;
    }

    public Fixture(String id, Date date, String homeTeamId, String awayTeamId, String stadiumId){
        this.id = id;
        this.date = date;
        this.homeTeam = new Team(homeTeamId, "", "");
        this.awayTeam = new Team(awayTeamId, "" , "");
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

    public String getAwayTeamId() {
        return this.awayTeam != null ? this.awayTeam.getId() : null;
    }

    public String getHomeTeamId() {
        return this.homeTeam != null ? this.homeTeam.getId() : null;
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
}
