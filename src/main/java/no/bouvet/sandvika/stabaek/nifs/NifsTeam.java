package no.bouvet.sandvika.stabaek.nifs;


import javax.persistence.*;
import java.util.List;

@Entity
public class NifsTeam {
    private String type;
    @Id
    private int id;
    private String uid;
    private String name;
    @Transient
    private NifsCountry country;
    private String url;
    private String address;
    private boolean clubTeam;
    private String gender;
    private int attendanceRecord;
    private String dateFounded;
    private String comment;
    @Transient
    private NifsPlace city;
    private boolean placeholder;
    @Transient
    private NifsImage logo;
    @Embedded
    @ElementCollection
    @CollectionTable(name = "stadiums")
    @OrderColumn
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column(name = "stadiums_type")),
            @AttributeOverride(name = "id", column = @Column(name = "stadiums_id")),
            @AttributeOverride(name = "uid", column = @Column(name = "stadiums_uid")),
            @AttributeOverride(name = "name", column = @Column(name = "stadiums_name")),
    })
    private List<NifsStadium> stadiums;
    @Transient
    private NifsName[] names;
    @Transient
    private NifsKit[] kits;
    @Transient
    private NifsHonour[] honours;
    @Embedded
    @ElementCollection
    @CollectionTable(name = "players")
    @OrderColumn
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column(name = "person_type")),
            @AttributeOverride(name = "id", column = @Column(name = "person_id")),
            @AttributeOverride(name = "uid", column = @Column(name = "person_uid")),
            @AttributeOverride(name = "name", column = @Column(name = "person_name")),
            @AttributeOverride(name = "comment", column = @Column(name = "person_comment")),
            @AttributeOverride(name = "gender", column = @Column(name = "person_gender")),
    })
    private List<NifsPerson> players;
    @Transient
    private NifsPerson[] staff;
    private boolean isYouthTeam;
    private boolean active;
    private int shirtNumber;

    public NifsTeam() {
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

    public NifsCountry getCountry() {
        return country;
    }

    public void setCountry(NifsCountry country) {
        this.country = country;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isClubTeam() {
        return clubTeam;
    }

    public void setClubTeam(boolean clubTeam) {
        this.clubTeam = clubTeam;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAttendanceRecord() {
        return attendanceRecord;
    }

    public void setAttendanceRecord(int attendanceRecord) {
        this.attendanceRecord = attendanceRecord;
    }

    public String getDateFounded() {
        return dateFounded;
    }

    public void setDateFounded(String dateFounded) {
        this.dateFounded = dateFounded;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public NifsPlace getCity() {
        return city;
    }

    public void setCity(NifsPlace city) {
        this.city = city;
    }

    public boolean isPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(boolean placeholder) {
        this.placeholder = placeholder;
    }

    public NifsImage getLogo() {
        return logo;
    }

    public void setLogo(NifsImage logo) {
        this.logo = logo;
    }

    public List<NifsStadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(List<NifsStadium> stadiums) {
        this.stadiums = stadiums;
    }

    public NifsName[] getNames() {
        return names;
    }

    public void setNames(NifsName[] names) {
        this.names = names;
    }

    public NifsKit[] getKits() {
        return kits;
    }

    public void setKits(NifsKit[] kits) {
        this.kits = kits;
    }

    public NifsHonour[] getHonours() {
        return honours;
    }

    public void setHonours(NifsHonour[] honours) {
        this.honours = honours;
    }

    public List<NifsPerson> getPlayers() {
        return players;
    }

    public void setPlayers(List<NifsPerson> players) {
        this.players = players;
    }

    public NifsPerson[] getStaff() {
        return staff;
    }

    public void setStaff(NifsPerson[] staff) {
        this.staff = staff;
    }

    public boolean isYouthTeam() {
        return isYouthTeam;
    }

    public void setYouthTeam(boolean youthTeam) {
        isYouthTeam = youthTeam;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }
}
