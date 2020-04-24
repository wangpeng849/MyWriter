package com.wangp.myaop.util;

import cn.hutool.core.date.DateTime;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * programName: fitaipolicy
 * fileName: DateUtil
 * author: ltl
 * createTime:2020/1/7 15:26
 */
@Slf4j
public class DateUtil {
    public final static String DATE_FORMAT_DEFAULT = "yyyy-MM-dd";
    public final static String DATE_FORMAT_HOUR = "yyyy-MM-dd HH";
    public final static String DATE_FORMAT_MINUTE = "yyyy-MM-dd HH:mm";
    public final static String DATE_FORMAT_SECOND = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_CHINA_DEFAULT = "yyyy年MM月dd日";

    /**
     * 获取指定日期前后num天的日期
     * @param date
     * @param num 正数 多少天之后的日期  负数 多少天之后的日期
     * @return
     */
    public static String getDay(String date, int num){
        return getDay(date, num,DATE_FORMAT_DEFAULT);
    }

    /**
     * 获取指定日期前后num天的日期
     * @param date
     * @param num 正数 多少天之后的日期  负数 多少天之后的日期
     * @param format 日期格式
     * @return
     */
    public static String getDay(String date, int num, String format){
        long t = parseStringToLong(date);
        return getDay(t, num, DATE_FORMAT_DEFAULT);
    }

    /**
     * 获取指定日期前后num天的日期
     * @param date
     * @param num 正数 多少天之后的日期  负数 多少天之后的日期
     * @return
     */
    public static String getDay(long date, int num){
        return getDay(date, num, DATE_FORMAT_DEFAULT);
    }

    /**
     * 获取指定日期前后num天的日期
     * @param date
     * @param num 正数 多少天之后的日期  负数 多少天之后的日期
     * @param format 日期格式
     * @return
     */
    public static String getDay(long date, int num, String format){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+num);
        return longToString(calendar.getTimeInMillis(),format);
    }

    /**
     * 将毫秒时间转换为yyyy-MM-dd格式的时间
     * @param time 毫秒数
     * @return
     */
    public static String longToString(long time) {
        return longToString(time, DATE_FORMAT_DEFAULT);
    }

    /**
     * 将毫秒时间转换为指定格式的时间
     * @param time 毫秒数
     * @param format 日期格式
     * @return
     */
    public static String longToString(long time, String format) {
        if (StringUtils.isBlank(format)) {
            format = DATE_FORMAT_DEFAULT;
        }
        DateTime dTime = new DateTime(time);
        return dTime.toString(format);
    }

    /**
     * 获取今天开始的时间
     * @return
     */
    public static Timestamp getTodayStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 001);
        return new Timestamp(cal.getTimeInMillis());
    }

    /**
     * 获取系统当前时间戳
     * @return
     */
    public static Timestamp getNowTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取指定日期开始的当日开始时间
     * @param date
     * @return
     */
    public static long getDayStartTime(String date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(parseStringToLong(date));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 001);
        return cal.getTimeInMillis();
    }

    /**
     * 获取指定日期结束时间
     * @param date
     * @return
     */
    public static long getDayEndTime(String date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(parseStringToLong(date));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTimeInMillis();
    }

    /**
     * 获得当前日期
     */
    public static String getCurrentTime() {
        return getCurrentTime("yyyy-MM-dd");
    }

    /**
     * 获得当前时间
     * @param format 日期格式
     * @return
     */
    public static String getCurrentTime(String format) {
        DateTime dTime = new DateTime();
        return dTime.toString(format);
    }

    /**
     * 将字符串类型的日期转换为毫秒数
     * @param dateStr
     * @return
     */
    public static long parseStringToLong(String dateStr) {
        dateStr = dateStr.trim();
        if (dateStr.length() == 19 || dateStr.length() == 23) {
            try {
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.set(Integer.parseInt(dateStr.substring(0, 4)),
                        Integer.parseInt(dateStr.substring(5, 7)) - 1,
                        Integer.parseInt(dateStr.substring(8, 10)),
                        Integer.parseInt(dateStr.substring(11, 13)),
                        Integer.parseInt(dateStr.substring(14, 16)),
                        Integer.parseInt(dateStr.substring(17, 19)));
                cal.set(java.util.Calendar.MILLISECOND, 0);
                return (cal.getTime().getTime());
            } catch (Exception e) {
                return 0;
            }

        } else if (dateStr.length() == 16) {
            try {
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.set(Integer.parseInt(dateStr.substring(0, 4)),
                        Integer.parseInt(dateStr.substring(5, 7)) - 1,
                        Integer.parseInt(dateStr.substring(8, 10)),
                        Integer.parseInt(dateStr.substring(11, 13)),
                        Integer.parseInt(dateStr.substring(14, 16)));
                cal.set(java.util.Calendar.MILLISECOND, 0);
                return (cal.getTime().getTime());
            } catch (Exception e) {
                return 0;
            }

        } else if (dateStr.length() == 14) {
            try {
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.set(Integer.parseInt(dateStr.substring(0, 4)),
                        Integer.parseInt(dateStr.substring(4, 6)) - 1,
                        Integer.parseInt(dateStr.substring(6, 8)),
                        Integer.parseInt(dateStr.substring(8, 10)),
                        Integer.parseInt(dateStr.substring(10, 12)),
                        Integer.parseInt(dateStr.substring(12, 14)));
                cal.set(java.util.Calendar.MILLISECOND, 0);
                return (cal.getTime().getTime());
            } catch (Exception e) {
                return 0;
            }
        } else if (dateStr.length() == 10 || dateStr.length() == 11) {
            try {
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.set(Integer.parseInt(dateStr.substring(0, 4)),
                        Integer.parseInt(dateStr.substring(5, 7)) - 1,
                        Integer.parseInt(dateStr.substring(8, 10)), 0, 0, 0);
                cal.set(java.util.Calendar.MILLISECOND, 0);
                return (cal.getTime().getTime());
            } catch (Exception e) {
                return 0;
            }
        } else if (dateStr.length() == 8 ) {
            try {
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.set(Integer.parseInt(dateStr.substring(0, 4)),
                        Integer.parseInt(dateStr.substring(4, 6)) - 1,
                        Integer.parseInt(dateStr.substring(6, 8)), 0, 0, 0);
                cal.set(java.util.Calendar.MILLISECOND, 0);
                return (cal.getTime().getTime());
            } catch (Exception e) {
                return 0;
            }
        } else {
            try {
                return Long.parseLong(dateStr);
            } catch (Exception e) {
                return 0;
            }

        }
    }

    /**
     * 假设传入的日期格式是yyyy-MM-dd HH:mm:ss, 也可以传入yyyy-MM-dd，如2018-1-1或者2018-01-01格式
     * @param strDate
     * @return
     */
    public static boolean isValidDate(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2018-02-29会被接受，并转换成2018-03-01
            format.setLenient(false);
            Date date = format.parse(strDate);

            ////判断传入的yyyy年-MM月-dd日 字符串是否为数字
            //String[] sArray = strDate.split("-");
            //for (String s : sArray) {
            //    boolean isNum = s.matches("[0-9]+");
            //    //+表示1个或多个（如"3"或"225"），*表示0个或多个（[0-9]*）（如""或"1"或"22"），?表示0个或1个([0-9]?)(如""或"7")
            //    if (!isNum) {
            //        return false;
            //    }
            //}
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String getFullFormateString(String str){
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            log.debug(e.getMessage());
        }

        return sdf.format(date);
    }
   }
