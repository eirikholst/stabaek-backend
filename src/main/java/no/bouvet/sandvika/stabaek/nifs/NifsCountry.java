package no.bouvet.sandvika.stabaek.nifs;

public class NifsCountry {
    private String type;
    private int id;
    private String uid;
    private String name;
    private String shortName;
    private int priority;
    private String CountryType;
    private String continent;
    private NifsTournament[] tournaments;

    public NifsCountry() {
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCountryType() {
        return CountryType;
    }

    public void setCountryType(String countryType) {
        CountryType = countryType;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public NifsTournament[] getTournaments() {
        return tournaments;
    }

    public void setTournaments(NifsTournament[] tournaments) {
        this.tournaments = tournaments;
    }
}
