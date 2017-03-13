package no.bouvet.sandvika.stabaek.nifs;

import java.lang.reflect.Array;
import java.util.Date;

public class NifsStage {
    private String type;
    private int id;
    private String uid;
    private String name;
    private String fullName;
    private String groupName;
    private int startYear;
    private int endYear;
    private Date startDate;
    private Date endDate;
    private int stageTypeId;
    private NifsTournament tournament;
    private Array data;
    private int visibilityId;
    private String comment;
    private NifsTeam[] teams;
    private NifsName[] names;
}
