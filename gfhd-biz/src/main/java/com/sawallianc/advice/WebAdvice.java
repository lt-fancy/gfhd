package com.sawallianc.advice;

import com.sawallianc.entity.Result;
import com.sawallianc.entity.ResultCode;
import com.sawallianc.exception.BizRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(
        annotations = {RestController.class, Controller.class}
)
public class WebAdvice {
    private final static Logger LOGGER = LoggerFactory.getLogger(WebAdvice.class);
    public WebAdvice(){

    }
    @ExceptionHandler
    public Object handleException(Exception e){
        Result result = Result.failResult();
        String msg;
        if(e instanceof BizRuntimeException){
            ResultCode resultCode = ((BizRuntimeException) e).getResultCode();
            result.setCode(resultCode.getCode());
            result.setMsg(resultCode.getMsg());
            msg = "[errorCode:"+result.getCode()+"]";
        } else {
            msg = "[errorCode: -1]";
        }
        LOGGER.error(msg);
        return result;
    }
}
