package no.bouvet.sandvika.stabaek.nifs;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class NifsTournament {
    private String type;
    private int id;
    private String uid;
    private String name;
    private String gender;
    private int level;
    @Embedded
    private NifsCountry country;
    private boolean neutralVenues;
    private int tournamentTypeId;
    private int tournamentCategoryId;
    private int visibilityId;
    @Embedded
    private NifsStage[] stages;

    public NifsTournament() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public NifsCountry getCountry() {
        return country;
    }

    public void setCountry(NifsCountry country) {
        this.country = country;
    }

    public boolean isNeutralVenues() {
        return neutralVenues;
    }

    public void setNeutralVenues(boolean neutralVenues) {
        this.neutralVenues = neutralVenues;
    }

    public int getTournamentTypeId() {
        return tournamentTypeId;
    }

    public void setTournamentTypeId(int tournamentTypeId) {
        this.tournamentTypeId = tournamentTypeId;
    }

    public int getTournamentCategoryId() {
        return tournamentCategoryId;
    }

    public void setTournamentCategoryId(int tournamentCategoryId) {
        this.tournamentCategoryId = tournamentCategoryId;
    }

    public int getVisibilityId() {
        return visibilityId;
    }

    public void setVisibilityId(int visibilityId) {
        this.visibilityId = visibilityId;
    }

    public NifsStage[] getStages() {
        return stages;
    }

    public void setStages(NifsStage[] stages) {
        this.stages = stages;
    }
}
