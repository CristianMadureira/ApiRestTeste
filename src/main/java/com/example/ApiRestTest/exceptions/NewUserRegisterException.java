package com.example.ApiRestTest.exceptions;

import org.springframework.http.HttpStatus;

public class NewUserRegisterException extends Exception{

    private HttpStatus errorCode;
    private String message;

    public NewUserRegisterException(HttpStatus errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
