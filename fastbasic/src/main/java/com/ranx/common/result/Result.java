package com.ranx.common.result;

/**
 * 返回结果
 * @author ranx
 * @create 2019-02-11 23:23
 **/
public class Result {
    private Integer code; //状态码
    private Object data; //返回数据

    public Result() {
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, com.ranx.utils.result.ResultEnums enums) {
        this.code = code;
        this.data = enums.getInfo();
    }

    public Result(Integer code, HttpExceptionEnum enums) {
        this.code = code;
        this.data = enums.getInfo();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
