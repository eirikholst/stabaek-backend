package no.bouvet.sandvika.stabaek.utils;

public class NifsUidUtils {
    public NifsUidUtils() {
    }

    public static String getNonCompactUid(String uid) {
        String[] stringSegments = uid.split("_");
        switch(stringSegments.length) {
            case 2:
                return uid;
            case 3:
                return getNonCompactUidOfThreeSegments(stringSegments);
            case 4:
                return getNonCompactUidOfFourSegments(stringSegments);
            default:
                return null;
        }
    }

    private static String getNonCompactUidOfThreeSegments(String[] stringSegments) {
        return stringSegments.length != 3?null:(!stringSegments[1].equals("c")?null:stringSegments[0] + "_" + stringSegments[2]);
    }

    private static String getNonCompactUidOfFourSegments(String[] stringSegments) {
        return stringSegments.length != 4?null:(!stringSegments[1].equals("c")?null:stringSegments[0] + "_" + stringSegments[2]);
    }

    public static String getStadiumUidFromHomeTeamUid(String homeTeamUid) {
        return getNonCompactUid(homeTeamUid) + "_s";
    }
}
