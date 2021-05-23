package com.ranx.common.constant;

/**
 * @author ranx
 * @create 2019-02-11 23:25
 * 200-299
 **/
public enum ResultEnums implements IEnumMessage{
    SUCCESS(200,"操作成功"),
    LOGIN_SUCCESS(201,"登录成功"),
    ;


    public int code;
    public String message;

    private ResultEnums( int code, String message) {
        this.message = message;
        this.code = code;
    }
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
