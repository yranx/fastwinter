package com.ranx.consts;


import java.util.ArrayList;
import java.util.List;

/**
 * 枚举
 *
 */
public enum ServiceEnum {

    PlatForm_QQ("qq",1),
    PlatForm_WX("qq",1),

    ;

    public int code;
    public String message;


    private ServiceEnum(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static List<EnumData> getValues() {
        List<EnumData> list = new ArrayList<>();
        for (ServiceEnum item : ServiceEnum.values()) {
            list.add(new EnumData(item.getCode(), item.getMessage()));
        }
        return list;

    }

    public static void main(String[] args) {
        getValues();
    }
}
