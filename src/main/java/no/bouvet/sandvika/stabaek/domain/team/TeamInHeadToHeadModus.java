package no.bouvet.sandvika.stabaek.domain.team;

public class TeamInHeadToHeadModus extends Team{

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

    public TeamInHeadToHeadModus() {
    }

    public TeamInHeadToHeadModus(int id, String name, String teamLogoUrl,
                                 int wonHome, int drawnHome, int lostHome,
                                 int goalsForHome, int goalsAgainstHome,
                                 int wonAway, int drawnAway, int lostAway,
                                 int goalsForAway, int goalsAgainstAway,
                                 int wonHomeForm, int drawnHomeForm,
                                 int lostHomeForm, int goalsForHomeForm,
                                 int goalsAgainsHomeFor, int wonAwayForm,
                                 int drawnAwayForm, int lostAwayForm,
                                 int goalsForAwayForm, int goalsAgainstAwayForm) {
        super(id, name, teamLogoUrl);
        this.wonHome = wonHome;
        this.drawnHome = drawnHome;
        this.lostHome = lostHome;
        this.goalsForHome = goalsForHome;
        this.goalsAgainstHome = goalsAgainstHome;
        this.wonAway = wonAway;
        this.drawnAway = drawnAway;
        this.lostAway = lostAway;
        this.goalsForAway = goalsForAway;
        this.goalsAgainstAway = goalsAgainstAway;
        this.wonHomeForm = wonHomeForm;
        this.drawnHomeForm = drawnHomeForm;
        this.lostHomeForm = lostHomeForm;
        this.goalsForHomeForm = goalsForHomeForm;
        this.goalsAgainstHomeFor = goalsAgainsHomeFor;
        this.wonAwayForm = wonAwayForm;
        this.drawnAwayForm = drawnAwayForm;
        this.lostAwayForm = lostAwayForm;
        this.goalsForAwayForm = goalsForAwayForm;
        this.goalsAgainstAwayForm = goalsAgainstAwayForm;
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
}
