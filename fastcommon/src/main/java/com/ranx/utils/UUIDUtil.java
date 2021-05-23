package com.ranx.utils;

import java.util.UUID;

/**
 * @author ranx
 * date: 2021年1月4日14:21:08
 */
public class UUIDUtil {

    public static String UUIDGenerate() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(UUIDGenerate().substring(0,8));
    }
}
