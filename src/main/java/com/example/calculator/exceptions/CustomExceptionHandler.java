package com.example.calculator.exceptions;

public class CustomExceptionHandler extends RuntimeException {

    private final static long serialVersionUID= 1L;

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

