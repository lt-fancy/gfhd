package com.sawallianc.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable{
    private int code;
    private String msg;
    private T data;
    private long runtime;
    private Result(){

    }
    private Result(T t,ResultCode resultCode,String msg){
        this.data = t;
        this.code = resultCode.getCode();
        this.msg = msg;
    }
    public static <T> Result<T> failResult(){
        return new Result((Object)null,ResultCode.ERROR,ResultCode.ERROR.getMsg());
    }
    public static <T> Result<T> getSuccessResult(T t){
        return new Result(t,ResultCode.SUCCESS,ResultCode.SUCCESS.getMsg());
    }
    public static <T> Result<T> buildResult(ResultCode resultCode){
        if(null == resultCode){
            resultCode = ResultCode.ERROR;
        }
        return new Result((Object)null,resultCode,resultCode.getMsg());
    }
    public static <T> Result<T> buildResult(T t,ResultCode resultCode){
        if(null == resultCode){
            resultCode = ResultCode.ERROR;
        }
        return new Result(t,resultCode,resultCode.getMsg());
    }
    public static <T> Result<T> buildResult(ResultCode resultCode,String msg){
        if(null == resultCode){
            resultCode = ResultCode.ERROR;
        }
        return new Result((Object)null,resultCode,msg);
    }
    public static <T> Result<T> buildResult(T t,ResultCode resultCode,String msg){
        if(null == resultCode){
            resultCode = ResultCode.ERROR;
        }
        return new Result(t,resultCode,msg);
    }

    public void setResultCode(ResultCode resultCode){
        if(null == resultCode){
            resultCode = ResultCode.ERROR;
        }
        this.code = resultCode.getCode();
    }
}
