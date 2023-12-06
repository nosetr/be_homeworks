package com.nosetr._20231206.taski;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String formatDateForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
    
    public static String formatTimeForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }

    public static String formatDateTimeForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(date);
    }
}

/**
 * My solution:
 */
class DateUtilsMy {
    public static String formatDateForDisplay(Date date) {
        return getDateTime(date, "dd/MM/yyyy");
    }
    
    public static String formatTimeForDisplay(Date date) {
        return getDateTime(date, "HH:mm:ss");
    }

    public static String formatDateTimeForDisplay(Date date) {
        return getDateTime(date, "dd/MM/yyyy HH:mm:ss");
    }
    
    private static String getDateTime(Date date, String format) {
    	return new SimpleDateFormat(format).format(date);
    }
}