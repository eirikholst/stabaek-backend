package no.bouvet.sandvika.stabaek.domain.team;

public class TeamInTableModus extends Team {
    private int place;
    private int played;
    private int won;
    private int drawn;
    private int lost;
    private int goalsScored;
    private int goalsConceded;
    private int goalDifference;
    private int points;
    private String lastSixMatches;
    private int changeSinceLastRound;
    private String form;

    public TeamInTableModus() {
    }

    public TeamInTableModus(int id, String name, String teamLogoUrl,
                            int place, int played, int won, int drawn, int lost,
                            int goalsScored, int goalsConceded, int goalDifference,
                            int points, String lastSixMatches, int changeSinceLastRound,
                            String form ) {
        super(id, name, teamLogoUrl);
        this.place = place;
        this.played = played;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.goalDifference = goalDifference;
        this.points = points;
        this.lastSixMatches = lastSixMatches;
        this.changeSinceLastRound = changeSinceLastRound;
        this.form = form;
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

    public int getDrawn() {
        return drawn;
    }

    public void setDrawn(int drawn) {
        this.drawn = drawn;
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

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
