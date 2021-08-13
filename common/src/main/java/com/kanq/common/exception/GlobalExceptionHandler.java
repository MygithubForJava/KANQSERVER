package com.kanq.common.exception;


import cn.hutool.core.util.ObjectUtil;
import com.kanq.common.vo.ApiResult;
import jdk.nashorn.internal.ir.ReturnNode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {
      private  final static Logger  logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 异常捕获错误拦截
     */
    @ExceptionHandler(value = Exception.class)
    public  ApiResult  handle(Exception e,HttpServletRequest request){
        if (e instanceof MethodArgumentNotValidException){
            debugLog(e,request);
            BindingResult result = ((MethodArgumentNotValidException)e).getBindingResult();
            return new ApiResult<>(BAD_REQUEST.value(),result.getAllErrors().get(0).getDefaultMessage());
        }
        if (e instanceof BindException){
            debugLog(e,request);
            BindingResult result = ((BindException)e).getBindingResult();
            return new ApiResult<>(BAD_REQUEST.value(),result.getAllErrors().get(0).getDefaultMessage());
        }

        if (e instanceof MissingServletRequestParameterException){
            debugLog(e,request);
            String parameterName = ((MissingServletRequestParameterException) e).getParameterName();
            return new ApiResult<>(BAD_REQUEST.value(),parameterName+"is miss");
        }

        if (e instanceof HttpMessageNotReadableException){
            debugLog(e,request);
            return new ApiResult<>(BAD_REQUEST.value(),BAD_REQUEST.getReasonPhrase());
        }

        if (e instanceof MethodArgumentTypeMismatchException){
            debugLog(e,request);
            String parameterName = ((MethodArgumentTypeMismatchException) e).getName();
            return new ApiResult<>(BAD_REQUEST.value(),"failed to convert"+parameterName);
        }
        errorLog(e,request);
        return  ApiResult.FAIL;
    }


    /**
     * 自定义业务异常捕获的机制
     */

    @ExceptionHandler(value = KanqException.class)
    public ApiResult  kanqHandler(Exception e,HttpServletRequest request){
       debugLog(e,request);
       KanqException exception=(KanqException) e;
       return new ApiResult<>(exception.getCode(),exception.getMessage());
    }

     @ExceptionHandler(value = ResultReturnException.class)
     public ApiResult resultReturnHandler(Exception e){

       ResultReturnException resultReturnException=(ResultReturnException) e;
       return new ApiResult(resultReturnException.getCode(),resultReturnException.getMessage());
    }

    /**
     * logger error记录
     */

    private   void  errorLog(Exception e, HttpServletRequest request){
        String remoteAddr = request.getRemoteAddr();
        String queryString = request.getQueryString();
        String  path=queryString!=null?(request.getRequestURI()+"?"+queryString):request.getRequestURI();
        logger.error("ip : {},path : {},message : {}",remoteAddr,path, e);
    }


    /**
     * logger debug记录
     */
    private   void  debugLog(Exception e, HttpServletRequest request){
        String remoteAddr = request.getRemoteAddr();
        String queryString = request.getQueryString();
        String  path=queryString!=null?(request.getRequestURI()+"?"+queryString):request.getRequestURI();
        logger.debug("ip : {},path : {},message : {}",remoteAddr,path, ObjectUtil.isNull(e.getMessage())?e:e.getMessage());
    }
}
