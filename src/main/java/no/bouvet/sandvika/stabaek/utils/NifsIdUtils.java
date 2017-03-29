package no.bouvet.sandvika.stabaek.utils;

public class NifsIdUtils {
    public NifsIdUtils() {
    }

    public static String getNonCompactIid(String id) {
        String[] stringSegments = id.split("_");
        switch(stringSegments.length) {
            case 1:
                return id;
            case 2:
                return getNonCompactIdOfTwoSegments(stringSegments);
            case 3:
                return getNonCompactIdOfThreeSegments(stringSegments);
            case 4:
                return getNonCompactIdOfFourSegments(stringSegments);
            default:
                return null;
        }
    }

    private static String getNonCompactIdOfTwoSegments(String[] stringSegments) {
        return stringSegments.length != 2 ? null : stringSegments[1];
    }

    private static String getNonCompactIdOfThreeSegments(String[] stringSegments) {
        if(stringSegments.length != 3) return null;
        if(stringSegments[0].equals("tim")) return stringSegments[1];
        if(stringSegments[1].equals("c")) return stringSegments[2];
        return null;
    }

    private static String getNonCompactIdOfFourSegments(String[] stringSegments) {
        return stringSegments.length != 4?null:(!stringSegments[1].equals("c") ? null : stringSegments[2]);
    }

    public static String getStadiumIdFromHomeTeamUid(String homeTeamUid) {
        return getNonCompactIid(homeTeamUid) + "_s";
    }
}
