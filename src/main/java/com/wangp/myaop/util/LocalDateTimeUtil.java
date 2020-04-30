package com.wangp.myaop.util;

import org.apache.tomcat.jni.Local;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @Author wangp
 * @Date 2020/4/29
 * @Version 1.0
 */
public class LocalDateTimeUtil {

    private final static String DATE_PARSE_HOUR = "yyyy-MM-dd HH:mm:ss";
    private final static String ZONE_OFFSET = "+8";

    public static long localDateTime2TimeStamp(LocalDateTime localDateTime) {
        return localDateTime.toEpochSecond(ZoneOffset.of(ZONE_OFFSET));
    }

    public static LocalDateTime timeStamp2LocalDateTime(long timeStamp) {
        return LocalDateTime.ofEpochSecond(timeStamp, 0, ZoneOffset.of(ZONE_OFFSET));
    }

    public static String localDateTime2String(LocalDateTime localDateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_PARSE_HOUR);
        return dtf.format(localDateTime);
    }

    public static LocalDateTime string2LocalDateTime(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_PARSE_HOUR);
        return LocalDateTime.parse(date, dtf);
    }

    public static Long string2TimeStamp(String date) {
        LocalDateTime localDateTime = string2LocalDateTime(date);
        return localDateTime2TimeStamp(localDateTime);
    }

    public static String timeStamp2String(long timeStamp) {
        LocalDateTime localDateTime = timeStamp2LocalDateTime(timeStamp);
        return localDateTime2String(localDateTime);
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTimeUtil.string2LocalDateTime("2020-04-29 16:30:30");
        System.out.println("字符串转localDateTime对象 ---> " + localDateTime);
        String time2String = LocalDateTimeUtil.localDateTime2String(localDateTime);
        System.out.println("localDateTime转字符串对象 ---> " + time2String);
        long timeStamp = LocalDateTimeUtil.localDateTime2TimeStamp(localDateTime);
        System.out.println("localDateTime转时间戳 ---> " + timeStamp);
        LocalDateTime localDateTimeBack = LocalDateTimeUtil.timeStamp2LocalDateTime(timeStamp);
        System.out.println("时间戳转localDateTime --> " + localDateTimeBack);
        String timeStamp2String = LocalDateTimeUtil.timeStamp2String(timeStamp);
        System.out.println("时间戳转字符串 ---> " + timeStamp2String);
        Long stamp = LocalDateTimeUtil.string2TimeStamp(timeStamp2String);
        System.out.println("字符串转时间戳 ---> " + stamp);
        String name = "xxxx";
    }
}
