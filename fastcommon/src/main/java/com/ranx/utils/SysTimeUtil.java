package com.ranx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取当前时间
 * @author ranx
 * @create 2019-01-10 22:17
 **/
public class SysTimeUtil {
    public static String getSysTime() {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间，也可使用当前时间戳
        String date = df.format(new Date());
        return date;
    }
}
