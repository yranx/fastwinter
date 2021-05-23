package com.ranx.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * @author ranx
 */
public class Base64Util {
    public static void main(String args[]) {
//        base64encoded("gzsBwbQ5XazCYFJM");
        base64decoded("Z3pzQndiUTVYYXpDWUZKTQ==");
    }

    //加密
    public static void base64encoded(String content) {
        try {
            // 使用基本编码
            String base64encodedString = Base64.getEncoder().encodeToString(content.getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);

            base64encodedString = Base64.getUrlEncoder().encodeToString(content.getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }

            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);

        } catch (UnsupportedEncodingException e) {
            System.out.println("Error :" + e.getMessage());
        }
    }

    //解密
    public static void base64decoded(String base64encodedString) {
        try {
            // 解码
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);

            System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));

        } catch (UnsupportedEncodingException e) {
            System.out.println("Error :" + e.getMessage());
        }
    }
}
