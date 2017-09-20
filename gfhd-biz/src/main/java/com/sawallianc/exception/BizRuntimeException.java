package com.sawallianc.exception;

import com.sawallianc.entity.ResultCode;

public class BizRuntimeException extends RuntimeException{
    private ResultCode resultCode;

    public BizRuntimeException(ResultCode resultCode,String errorMsg){
        super(errorMsg);
        this.resultCode = resultCode;
    }
    public BizRuntimeException(ResultCode resultCode,String errorMsg,Throwable throwable){
        super(errorMsg,throwable);
        this.resultCode = resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
