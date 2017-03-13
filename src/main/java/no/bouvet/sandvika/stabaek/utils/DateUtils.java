package no.bouvet.sandvika.stabaek.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
    public DateUtils() {
    }

    public static String getReadableString(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        sdf.setCalendar(calendar);
        return sdf.format(calendar.getTime());
    }
}
