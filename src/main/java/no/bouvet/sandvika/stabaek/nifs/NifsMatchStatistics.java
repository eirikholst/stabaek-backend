package no.bouvet.sandvika.stabaek.nifs;

import javax.persistence.Embeddable;

@Embeddable
public class NifsMatchStatistics {
    private String type;
    private int id;
    private String uid;
    private int shotsOnGoalHomeTeam;
    private int shotsOnGoalAwayTeam;
    private int totalShotsHomeTeam;
    private int totalShotsAwayTeam;

    public NifsMatchStatistics() {
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

    public int getShotsOnGoalHomeTeam() {
        return shotsOnGoalHomeTeam;
    }

    public void setShotsOnGoalHomeTeam(int shotsOnGoalHomeTeam) {
        this.shotsOnGoalHomeTeam = shotsOnGoalHomeTeam;
    }

    public int getShotsOnGoalAwayTeam() {
        return shotsOnGoalAwayTeam;
    }

    public void setShotsOnGoalAwayTeam(int shotsOnGoalAwayTeam) {
        this.shotsOnGoalAwayTeam = shotsOnGoalAwayTeam;
    }

    public int getTotalShotsHomeTeam() {
        return totalShotsHomeTeam;
    }

    public void setTotalShotsHomeTeam(int totalShotsHomeTeam) {
        this.totalShotsHomeTeam = totalShotsHomeTeam;
    }

    public int getTotalShotsAwayTeam() {
        return totalShotsAwayTeam;
    }

    public void setTotalShotsAwayTeam(int totalShotsAwayTeam) {
        this.totalShotsAwayTeam = totalShotsAwayTeam;
    }
}
