package com.ictbda.iot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @Auther: czz
 * @Date: 2020/3/6 13:41
 * @Description:
 */
public class DateUtils {

    private static Logger logger = Logger.getLogger("DateUtils");
    public static final String YYYYMMDD = "yyyy-MM-dd";

    public static String convertLongToString(long longDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String string = sdf.format(longDate);
        return string;
    }

    public static String convertLongToString(long longDate,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String string = sdf.format(longDate);
        return string;
    }

    /**
     *
     * @param strDate
     * @return
     */
    public static Date parseDate(String strDate) {
        return parseDate(strDate, null);
    }

    /**
     * parseDate
     *
     * @param strDate
     * @param pattern
     * @return
     */
    public static Date parseDate(String strDate, String pattern) {
        Date date = null;
        try {
            if (pattern == null) {
                pattern = YYYYMMDD;
            }
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            date = format.parse(strDate);
        } catch (Exception e) {
            logger.info("parseDate error:" + e);
        }
        return date;
    }
    /**
     * format date
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        String strDate = null;
        try {
            if (pattern == null) {
                pattern = YYYYMMDD;
            }
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            strDate = format.format(date);
        } catch (Exception e) {
            logger.info("formatDate error:" +e);
        }
        return strDate;
    }
}
