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
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column(name = "logo_type")),
            @AttributeOverride(name = "id", column = @Column(name = "logo_id")),
            @AttributeOverride(name = "uid", column = @Column(name = "logo_uid")),
            @AttributeOverride(name = "url", column = @Column(name = "logo_url"))
    })
    private NifsImage logo;
    @Embedded
    @ElementCollection
    @CollectionTable(name = "stadiums")
    @OrderColumn
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column(name = "stadium_type")),
            @AttributeOverride(name = "id", column = @Column(name = "stadium_id")),
            @AttributeOverride(name = "uid", column = @Column(name = "stadium_uid")),
            @AttributeOverride(name = "name", column = @Column(name = "stadium_name")),
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

    private int wonHome;
    private int drawnHome;
    private int lostHome;
    private int goalsForHome;
    private int goalsAgainstHome;
    private int wonAway;
    private int drawnAway;
    private int lostAway;
    private int goalsForAway;
    private int goalsAgainstAway;
    private int wonHomeForm;
    private int drawnHomeForm;
    private int lostHomeForm;
    private int goalsForHomeForm;
    private int goalsAgainstHomeFor;
    private int wonAwayForm;
    private int drawnAwayForm;
    private int lostAwayForm;
    private int goalsForAwayForm;
    private int goalsAgainstAwayForm;

    private int place;
    private int played;
    private int won;
    private int draw;
    private int lost;
    private int goalsScored;
    private int goalsConceded;
    private int goalDifference;
    private int points;
    private String lastSixMatches;
    private int changeSinceLastRound;

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

    public int getWonHome() {
        return wonHome;
    }

    public void setWonHome(int wonHome) {
        this.wonHome = wonHome;
    }

    public int getDrawnHome() {
        return drawnHome;
    }

    public void setDrawnHome(int drawnHome) {
        this.drawnHome = drawnHome;
    }

    public int getLostHome() {
        return lostHome;
    }

    public void setLostHome(int lostHome) {
        this.lostHome = lostHome;
    }

    public int getGoalsForHome() {
        return goalsForHome;
    }

    public void setGoalsForHome(int goalsForHome) {
        this.goalsForHome = goalsForHome;
    }

    public int getGoalsAgainstHome() {
        return goalsAgainstHome;
    }

    public void setGoalsAgainstHome(int goalsAgainstHome) {
        this.goalsAgainstHome = goalsAgainstHome;
    }

    public int getWonAway() {
        return wonAway;
    }

    public void setWonAway(int wonAway) {
        this.wonAway = wonAway;
    }

    public int getDrawnAway() {
        return drawnAway;
    }

    public void setDrawnAway(int drawnAway) {
        this.drawnAway = drawnAway;
    }

    public int getLostAway() {
        return lostAway;
    }

    public void setLostAway(int lostAway) {
        this.lostAway = lostAway;
    }

    public int getGoalsForAway() {
        return goalsForAway;
    }

    public void setGoalsForAway(int goalsForAway) {
        this.goalsForAway = goalsForAway;
    }

    public int getGoalsAgainstAway() {
        return goalsAgainstAway;
    }

    public void setGoalsAgainstAway(int goalsAgainstAway) {
        this.goalsAgainstAway = goalsAgainstAway;
    }

    public int getWonHomeForm() {
        return wonHomeForm;
    }

    public void setWonHomeForm(int wonHomeForm) {
        this.wonHomeForm = wonHomeForm;
    }

    public int getDrawnHomeForm() {
        return drawnHomeForm;
    }

    public void setDrawnHomeForm(int drawnHomeForm) {
        this.drawnHomeForm = drawnHomeForm;
    }

    public int getLostHomeForm() {
        return lostHomeForm;
    }

    public void setLostHomeForm(int lostHomeForm) {
        this.lostHomeForm = lostHomeForm;
    }

    public int getGoalsForHomeForm() {
        return goalsForHomeForm;
    }

    public void setGoalsForHomeForm(int goalsForHomeForm) {
        this.goalsForHomeForm = goalsForHomeForm;
    }

    public int getGoalsAgainstHomeFor() {
        return goalsAgainstHomeFor;
    }

    public void setGoalsAgainstHomeFor(int goalsAgainstHomeFor) {
        this.goalsAgainstHomeFor = goalsAgainstHomeFor;
    }

    public int getWonAwayForm() {
        return wonAwayForm;
    }

    public void setWonAwayForm(int wonAwayForm) {
        this.wonAwayForm = wonAwayForm;
    }

    public int getDrawnAwayForm() {
        return drawnAwayForm;
    }

    public void setDrawnAwayForm(int drawnAwayForm) {
        this.drawnAwayForm = drawnAwayForm;
    }

    public int getLostAwayForm() {
        return lostAwayForm;
    }

    public void setLostAwayForm(int lostAwayForm) {
        this.lostAwayForm = lostAwayForm;
    }

    public int getGoalsForAwayForm() {
        return goalsForAwayForm;
    }

    public void setGoalsForAwayForm(int goalsForAwayForm) {
        this.goalsForAwayForm = goalsForAwayForm;
    }

    public int getGoalsAgainstAwayForm() {
        return goalsAgainstAwayForm;
    }

    public void setGoalsAgainstAwayForm(int goalsAgainstAwayForm) {
        this.goalsAgainstAwayForm = goalsAgainstAwayForm;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getLastSixMatches() {
        return lastSixMatches;
    }

    public void setLastSixMatches(String lastSixMatches) {
        this.lastSixMatches = lastSixMatches;
    }

    public int getChangeSinceLastRound() {
        return changeSinceLastRound;
    }

    public void setChangeSinceLastRound(int changeSinceLastRound) {
        this.changeSinceLastRound = changeSinceLastRound;
    }
}
