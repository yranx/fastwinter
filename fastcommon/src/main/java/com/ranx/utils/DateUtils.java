package com.ranx.utils;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author
 * @ClassName: DateUtils
 * @Description: 时间处理类
 * @date 2019-12-04 17:49
 */
@Slf4j
public class DateUtils {
    private static final String DATE_FORMATER = "yyyy-MM-dd";
    private static final String DATETIME_FORMATER = "yyyy-MM-dd HH:mm:ss";
    private static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 获取日期
     * yyyyMMdd
     *
     * @return
     */
    public static String getDate() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    /**
     * 获取日期
     * yyyy-MM-dd
     *
     * @return
     */
    public static String getDateA() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 获取当前时间字符串
     *
     * @return yyyy-MM-dd HH:mm:ss
     * @author
     * create on 2016-5-8  下午03:42:50
     */
    public static String getDatetime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 自定义日期转换
     */
    public static String formateDate(Date dt, String pattern) {
        return new SimpleDateFormat(pattern).format(dt);
    }

    /**
     * 操作日期
     *
     * @param dt
     * @param amt
     * @return
     */
    public static String opDate(Date dt, int amt, String formater) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dt);
        calendar.add(Calendar.DATE, amt);
        dt = calendar.getTime();
        return formateDate(dt, formater);
    }

    /**
     * 以当前时间操作日期
     *
     * @param amt
     * @return
     */
    public static String opDate(int amt) {
        return opDate(new Date(), amt, DATE_FORMATER);
    }

    /**
     * 以当前时间操作日期
     *
     * @param amt
     * @return
     */
    public static String opDateMM_DD(int amt) {
        return opDate(new Date(), amt, "MM-dd");
    }

    /**
     * 以秒为单位操作时间
     *
     * @param dt
     * @param second
     * @param formater
     * @return
     */
    public static String opSecond(Date dt, int second, String formater) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dt);
        calendar.add(Calendar.SECOND, second);
        dt = calendar.getTime();
        return formateDate(dt, formater);
    }

    /**
     * 以秒为单位操作日期
     *
     * @param second
     * @return
     */
    public static Timestamp opSecond(int second) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND, second);
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * 获取Timestamp
     *
     * @return
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 校验字符串日期格式是否合法
     *
     * @param dateStr 20140626351206 20141222
     * @param format  yyyyMMddHHmmss YYYYMMdd
     * @return true：验证成功  false：错误
     */
    public static boolean valDataPattern(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 计算当前时间减去N分钟后的时间
     *
     * @param h 需要减的分钟
     */
    public static String getTimeByMinusH(int h) {
        long currenTime = System.currentTimeMillis();
        currenTime -= h * 60 * 1000;
        Date date = new Date(currenTime);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    /**
     * 计算当前时间加N分钟后的时间
     *
     * @param h 需要减的分钟
     */
    public static Timestamp getTimeByPlusH(int h) {
        long currenTime = System.currentTimeMillis();
        currenTime += h * 60 * 1000;
        return new Timestamp(currenTime);
    }

    public static Date getDate(LocalDateTime localDateTime) {
        String format = localDateTime.format(DateTimeFormatter.ofPattern(DATETIME_FORMATER));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMATER);
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(format);
        } catch (Exception e) {

        }
        return parse;
    }

    public static LocalDateTime getLocalDateTime(Date date) {
        LocalDateTime parse = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMATER);
            String localStr = simpleDateFormat.format(date);
            parse = LocalDateTime.parse(localStr, DateTimeFormatter.ofPattern(DATETIME_FORMATER));
        } catch (Exception e) {

        }
        return parse;
    }

    public static LocalDateTime getLocalDateTimeFromStr(String localStr) {
        LocalDateTime parse = null;
        try {
            parse = LocalDateTime.parse(localStr, DateTimeFormatter.ofPattern(DATETIME_FORMATER));
        } catch (Exception e) {

        }
        return parse;
    }

    public static String getLocalDateTimeStr(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(DATETIME_FORMATER));
    }

    public static LocalDateTime getyyyyMMddHHmmss(String time) {
        LocalDateTime parse = null;
        try {
            parse = LocalDateTime.parse(time, DateTimeFormatter.ofPattern(YYYYMMDDHHMMSS));
        } catch (Exception e) {
//            log.error("时间转换错误", e);
        }
        return parse;
    }

    public static String getMonthDay(LocalDate localDate) {
        String format = localDate.format(DateTimeFormatter.ofPattern(DATE_FORMATER));
        return format.substring(format.indexOf("-") + 1);
    }

    public static String getMonthDayAll(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMATER));
    }

    public static String getTimeStr(Long time) {
        if (time == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        long hour = time / 3600;
        long s = time % 3600;
        long minute = s / 60;
        long second = s % 60;
        if (hour != 0) {
            sb.append(hour).append("时");
        }
        if (minute != 0) {
            sb.append(minute).append("分");
        }
        if (second != 0) {
            sb.append(second).append("秒");
        }
        return sb.toString();
    }

}