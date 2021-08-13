package com.kanq.common.exception;

import com.kanq.common.enums.ResultEnum;
import lombok.Data;

@Data
public class ResultReturnException extends RuntimeException{

    private Integer code;


    public ResultReturnException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.setCode(resultEnum.getCode());
    }
    public ResultReturnException(Integer code,String message) {
        super(message);
        this.setCode(code);
    }
}
