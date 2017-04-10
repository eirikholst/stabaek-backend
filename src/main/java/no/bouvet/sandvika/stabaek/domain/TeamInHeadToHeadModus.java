package no.bouvet.sandvika.stabaek.domain;

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

    public TeamInHeadToHeadModus(String id, String name, String teamLogoUrl,
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

    public int getDrawnHome() {
        return drawnHome;
    }

    public int getLostHome() {
        return lostHome;
    }

    public int getGoalsForHome() {
        return goalsForHome;
    }

    public int getGoalsAgainstHome() {
        return goalsAgainstHome;
    }

    public int getWonAway() {
        return wonAway;
    }

    public int getDrawnAway() {
        return drawnAway;
    }

    public int getLostAway() {
        return lostAway;
    }

    public int getGoalsForAway() {
        return goalsForAway;
    }

    public int getGoalsAgainstAway() {
        return goalsAgainstAway;
    }

    public int getWonHomeForm() {
        return wonHomeForm;
    }

    public int getDrawnHomeForm() {
        return drawnHomeForm;
    }

    public int getLostHomeForm() {
        return lostHomeForm;
    }

    public int getGoalsForHomeForm() {
        return goalsForHomeForm;
    }

    public int getGoalsAgainstHomeFor() {
        return goalsAgainstHomeFor;
    }

    public int getWonAwayForm() {
        return wonAwayForm;
    }

    public int getDrawnAwayForm() {
        return drawnAwayForm;
    }

    public int getLostAwayForm() {
        return lostAwayForm;
    }

    public int getGoalsForAwayForm() {
        return goalsForAwayForm;
    }

    public int getGoalsAgainstAwayForm() {
        return goalsAgainstAwayForm;
    }
}
