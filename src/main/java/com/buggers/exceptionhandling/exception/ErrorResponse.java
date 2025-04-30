package com.buggers.exceptionhandling.exception;

import lombok.Data;

@Data
public class ErrorResponse {

    private Object timestamp;
    private Object message;
    private Object status;
    public ErrorResponse(Object timestamp,Object message,Object status){
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
    }

}
