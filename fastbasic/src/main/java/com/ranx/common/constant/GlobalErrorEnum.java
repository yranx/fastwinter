package com.ranx.common.constant;

/**
 * 错误提示枚举
 * 100-199
 */
public enum GlobalErrorEnum implements IEnumMessage {

    SYSTEM_UNDEFINED(100, ""),//服务内部自定义错误
    SYSTEM_NOLOGN(101, "未登录"),
    SYSTEM_PERMISSION_DENIED(102, "没有权限"),
    SYSTEM_ERROR_PASSWORD_USERNAME(103, "用户名密码错误"),
    SYSTEM_SIGNINVALID(104, "签名错误"),
    SYSTEM_TIMESTAMP_INVALID(105, "调用时间过期"),
    SYSTEM_NULL_DATA(106, "数据为空"),
    SYSTEM_PARAMETER_NULL(107, "参数为空"),
    SYSTEM_PARAMETER_ERROR(108, "参数错误"),
    SYSTEM_OPERATE_UNALLOWED(109, "不合法的操作"),
    SYSTEM_GATEWAY(110, "网关错误"),
    SYSTEM_SERVICE_TIMEOUT(111, "服务超时"),
    SYSTEM_FILE_TOO_LARGE(112, "文件过大"),
    SYSTEM_DEFAULT(113, "服务内部错误"),//默认错误提示
    REPEAT_OPERATE(114, "重复提交"),
    SYSTEM_LOGIN_FAIL(115, "登录失败"),


    SYSTEM_SERVICE_FALL(999, "服务调用失败"),



    ;
    public int code;
    public String message;

    private GlobalErrorEnum(int code, String msg) {
        this.code = code;
        this.message = msg;
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
