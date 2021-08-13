package com.kanq.common.exception;


import com.kanq.common.enums.CodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class KanqException extends  RuntimeException{

    private static final long serialVersionUID = -8977907937339727821L;

    private  Integer code;

    public KanqException(){
        super();
    }

    public KanqException(String message) {
        super(message);
        this.setCode(CodeEnum.FAILED.getCode());
    }

    public KanqException(CodeEnum codeEnum) {
         super(codeEnum.getMessage());
         this.setCode(codeEnum.getCode());
    }

    public KanqException(String message,Throwable cause) {
        super(message,cause);
    }
    public KanqException(Integer code,String message){
        super(message);
        this.setCode(code);
    }
}
