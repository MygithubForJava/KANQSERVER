package com.kanq.common.vo;


import com.kanq.common.enums.CodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 *统一数据返回类
 */
@Data
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 2006656273278063933L;

    private  Integer code;
    private  String message;
    private  T data;


    public static final ApiResult SUCCESS = new ApiResult(true);
    public static final ApiResult FAIL = new ApiResult(false);

    public ApiResult() {
    }

    public ApiResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResult(T data) {
        this.data=data;
    }

    public ApiResult(boolean bool) {
        this.code=bool? CodeEnum.SUCCESS.getCode() : CodeEnum.FAILED.getCode();
        this.message=bool? CodeEnum.SUCCESS.getMessage() : CodeEnum.FAILED.getMessage();
    }

   public static ApiResult  success(Object o){return new ApiResult<>(o);}



}
