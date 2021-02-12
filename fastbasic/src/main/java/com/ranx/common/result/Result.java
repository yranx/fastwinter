package com.ranx.common.result;

import com.ranx.common.constant.GlobalErrorEnum;
import com.ranx.common.constant.IEnumMessage;
import com.ranx.common.request.QueryReq;

import java.io.Serializable;

/**
 * 返回结果
 * @author ranx
 * @create 2019-02-11 23:23
 **/
public class Result<T>  implements Serializable {

    public static final  int SUCCESS= 0;
    public static  final String  DEFAULT_SUCCESS_MESSAGE="success";
    private static final long serialVersionUID = -4879176164351146238L;
    private int code;
    private String message;
    private T data;


    /**
     * 禁止外部实例化，默认成功
     */
    protected Result()
    {
        code=SUCCESS;
        message=DEFAULT_SUCCESS_MESSAGE;
    }

    /**
     * 禁止外部实例化，默认成功 带数据
     * @param data
     */
    protected Result(T data)
    {
        this();
        this.data=data;
    }

    /**
     * 禁止外部实例化，返回值 自定义
     * @param message
     * @param data
     */
    protected Result(IEnumMessage message, T data)
    {
        code=message.getCode();
        this.message=message.getMessage();
        this.data=data;
    }

    /**
     * 禁止外部实例化，返回值 自定义
     * @param message
     */
    protected  Result(String message)
    {
        code= GlobalErrorEnum.SYSTEM_UNDEFINED.getCode();
        this.message=message;
        this.data=null;
    }

    /**
     * 返回成功的数据
     * @return
     */
    public static Result success()
    {
        return new Result();
    }

    /**
     * 返回成功的数据
     * @param data
     * @param <T>
     * @return
     */
    public static <T>  Result success(T data)
    {
        return new Result(data);
    }


    /**
     * 查询DTO对象封装
     * @param <T>
     * @return
     */
    public static <T>  Result<PagingDto<T>> pagingSuccess(T data, QueryReq queryDto)
    {
        PagingDto<T> dto= new PagingDto<>();
        dto.data=data;
        dto.setPageSize(queryDto.getPageSize());
        dto.setPageIndex(queryDto.getPageIndex());
        //如果前端有传这个值，则说明总数不需要再进行查询
        if (queryDto.getTotal() > 0) {
            dto.setTotal(queryDto.getTotal());
        }
        return new  Result(dto);
    }

    /**
     * 查询DTO对象封装
     * @param data
     * @param queryDto
     * @param total
     * @param <T>
     * @return
     */
    public static <T> Result<PagingDto<T>> pagingSuccess(T data, QueryReq queryDto, int total)
    {
        PagingDto<T> dto= new PagingDto<>();
        dto.data=data;
        dto.setPageSize(queryDto.getPageSize());
        dto.setPageIndex(queryDto.getPageIndex());
        dto.setTotal(total);
        return new  Result(dto);
    }

    /**
     * 操作失败返回dto
     * @param
     * @return
     */
    public static  Result  fail()
    {
        return new Result (GlobalErrorEnum.SYSTEM_DEFAULT,null);
    }

    /**
     * 操作失败返回dto
     * @param enumMessage
     * @return
     */
    public static  Result  fail(IEnumMessage  enumMessage)
    {
        return new Result(enumMessage,null);
    }

    /**
     * 操作失败返回dto
     * @param enumMessage  枚举
     * @param data  返回的数据
     * @param <T>
     * @return
     */
    public  static <T> Result fail(IEnumMessage enumMessage,T data)
    {
        return  new Result(enumMessage,data);
    }

    /**
     * 操作失败返回dto
     * @param message  自定义的错误
     * @param
     * @return
     */
    public  static   Result  fail(String message)
    {
        return new Result(message);
    }

}
