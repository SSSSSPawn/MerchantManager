package com.bec.merchantmanager.net.exception;

/**
 * Created by admin on 2017/9/13.
 */

public class AppException extends RuntimeException {

    private String code;

    private String message;

    public AppException(String message){
        super(message);
        this.message = message;
    }

    public AppException(String code,String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
