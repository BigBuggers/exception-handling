package com.buggers.exceptionhandling.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResourceNotFoundException extends RuntimeException {
    private ErrorMessage errorMessage;

    public ResourceNotFoundException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
}
