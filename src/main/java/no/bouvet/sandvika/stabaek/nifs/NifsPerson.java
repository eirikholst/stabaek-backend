package no.bouvet.sandvika.stabaek.nifs;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Embeddable
public class NifsPerson {
    private String type;
    private int id;
    private String uid;
    private String name;
    private String firstName;
    private String lastName;
    private String nickName;
    private String shirtName;
    @Transient
    private NifsName[] names;
    @Transient
    private NifsPosition position;
    private Date birthDate;
    @Transient
    private NifsCountry country;
    private String gender;
    private String homePage;
    private int height;
    private boolean isAReferee;
    private String comment;
    private Date hungUpBootsDate;
    private Date deathDate;
    @Transient
    private NifsPlace birthPlace;
    @Transient
    private NifsTeam[] teams;
    @Transient
    private NifsTransfer[] transfers;
    @Transient
    private List<NifsStageStatistics> stageStatistics;
    @Transient
    private NifsImage profilePicture;
    @Transient
    private NifsKit kit;
    private boolean startsMatch;
    private boolean startsOnTheBench;

    public NifsPerson() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getShirtName() {
        return shirtName;
    }

    public void setShirtName(String shirtName) {
        this.shirtName = shirtName;
    }

    public NifsName[] getNames() {
        return names;
    }

    public void setNames(NifsName[] names) {
        this.names = names;
    }

    public NifsPosition getPosition() {
        return position;
    }

    public void setPosition(NifsPosition position) {
        this.position = position;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public NifsCountry getCountry() {
        return country;
    }

    public void setCountry(NifsCountry country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isAReferee() {
        return isAReferee;
    }

    public void setAReferee(boolean AReferee) {
        isAReferee = AReferee;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getHungUpBootsDate() {
        return hungUpBootsDate;
    }

    public void setHungUpBootsDate(Date hungUpBootsDate) {
        this.hungUpBootsDate = hungUpBootsDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public NifsPlace getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(NifsPlace birthPlace) {
        this.birthPlace = birthPlace;
    }

    public NifsTeam[] getTeams() {
        return teams;
    }

    public void setTeams(NifsTeam[] teams) {
        this.teams = teams;
    }

    public NifsTransfer[] getTransfers() {
        return transfers;
    }

    public void setTransfers(NifsTransfer[] transfers) {
        this.transfers = transfers;
    }

    public List<NifsStageStatistics> getStageStatistics() {
        return stageStatistics;
    }

    public void setStageStatistics(List<NifsStageStatistics> stageStatistics) {
        this.stageStatistics = stageStatistics;
    }

    public NifsImage getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(NifsImage profilePicture) {
        this.profilePicture = profilePicture;
    }

    public NifsKit getKit() {
        return kit;
    }

    public void setKit(NifsKit kit) {
        this.kit = kit;
    }

    public boolean isStartsMatch() {
        return startsMatch;
    }

    public void setStartsMatch(boolean startsMatch) {
        this.startsMatch = startsMatch;
    }

    public boolean isStartsOnTheBench() {
        return startsOnTheBench;
    }

    public void setStartsOnTheBench(boolean startsOnTheBench) {
        this.startsOnTheBench = startsOnTheBench;
    }
}
