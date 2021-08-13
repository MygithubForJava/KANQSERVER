package com.kanq.common.enums;


import lombok.Getter;

/**
 * 返回结果枚举类
 */
@Getter
public enum ResultEnum {

    SUCCESS(1,"成功"),
    FAILED(0,"失败"),
    ACCOUNT_ALREAD_EXIST(0,"账号已存在"),
    USER_ALREAD_EXIST(0,"用户已存在")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
