package com.example.calculator.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CustomExceptionHandler extends RuntimeException {

    public CustomExceptionHandler() {
        super();
    }
    public CustomExceptionHandler(String message) {
        super(message);
    }

    public CustomExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }
}

