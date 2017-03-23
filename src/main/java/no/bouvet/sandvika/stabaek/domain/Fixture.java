package no.bouvet.sandvika.stabaek.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private String homeTeamNameString;
    private String awayTeamNameString;
    private String stadiumNameString;
    private Date date;
    private String readableDate;
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
        this.name = homeTeam.getName() + " - " + awayTeam.getName();
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
        if(homeTeam != null && homeTeam.getName() != null) {
            this.homeTeamNameString = homeTeam.getName();
        }

    }

    public Team getAwayTeam() {
        return this.awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
