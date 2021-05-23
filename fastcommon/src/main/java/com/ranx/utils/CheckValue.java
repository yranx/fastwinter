package com.ranx.utils;

/**
 * 校验参数的工具类
 * @author ranx
 * @create 2019-02-11 23:45
 **/
public class CheckValue {
    public static boolean checkPage(Integer a, Integer b) {
        if (a != null && a != 0 && b != null && b != 0) {
            return true;
        }
        return false;
    }

    public static boolean checkPageIds(Integer a, Integer b, Integer c) {
        if (a != null && a != 0 && b != null && b != 0 && c != null && c != 0) {
            return true;
        }
        return false;
    }

    public static boolean checkId(Long id) {
        if (id != null && id != 0) {
            return true;
        }
        return false;
    }

    public static boolean checkObj(Object obj) {
        if (obj != null) {
            return true;
        }
        return false;
    }

    public static boolean checkIds(Long... ids) {
        if (ids != null && ids.length > 0) {
            return true;
        } else {
            return false;
        }
    }
}
