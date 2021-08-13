package com.kanq.common.enums;


import lombok.Getter;

@Getter
public enum CodeEnum {

    /**
     * 通用返回码
     */
    SUCCESS(200,"操作成功"),
    FAILED(500,"系统异常");


    private  Integer code;
    private  String message;

     CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
