package com.ranx.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ranx
 */
public class TimeUtil {
    public static void main(String[] args) {


        dateTimeFoematter();
    }

    public static void dayRemindTime() {
        Date zeroTime = DateUtils.truncate(new Date(), Calendar.DATE);
        Calendar c = Calendar.getInstance();
        c.setTime(zeroTime);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date endTime = c.getTime();
        Date date = new Date();
        long maxTime = (endTime.getTime() - date.getTime()) / 1000;
        if (0 == maxTime) {
            maxTime = 24 * 60 * 60;
        }
    }

    public static void dateTimeFoematter() {

        //解析日期
        String dateStr = "2016年10月25日";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        System.out.println(date);

        //日期转换为字符串
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm a");
        String nowStr = now.format(format);
        System.out.println(nowStr);


        System.out.println(
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm a"))
        );
        System.out.println(
                DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm a").format(LocalDateTime.now())
        );
    }
}
