package com.ictbda.iot.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @Auther: czz
 * @Date: 2020/3/6 13:41
 * @Description:
 */
public class DateUtils {

    /**
     * 常见日期格式
     */
    public static final String PATTERN_ONE = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_TWO = "yyyy-MM-dd";
    public static final String PATTERN_THREE = "yyyy/MM/dd HH/mm/ss";
    public static final String PATTERN_FOUR = "yyyyMMddHHmmss";
    private static Logger logger = Logger.getLogger("DateUtils");


    public static String convertLongToString(long longDate){
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_ONE);
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
                pattern = PATTERN_TWO;
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
                pattern = PATTERN_TWO;
            }
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            strDate = format.format(date);
        } catch (Exception e) {
            logger.info("formatDate error:" +e);
        }
        return strDate;
    }

    /**
     * utc时间转换为北京时间
     * @param date
     * @return
     */
    public static Date utcToBeijing(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
        return calendar.getTime ();
    }
}
