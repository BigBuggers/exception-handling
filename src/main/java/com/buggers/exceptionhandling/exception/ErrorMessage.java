package com.buggers.exceptionhandling.exception;

public enum ErrorMessage {
    NOT_FOUND("Resource Not Found");
    private final String message;
    ErrorMessage(String message){
        this.message = message;
    }
    public String value(){
        return this.message;
    }
}
