package com.example.ApiRestTest.handler;

public class ErrorMessageResponse {

    private  String message;

    public ErrorMessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
