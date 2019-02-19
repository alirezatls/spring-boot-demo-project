package com.demo.restservice.restservicedemohateoas.exception;

public class ExceptionTemplate {

    private String message;
    private String cause;

    public ExceptionTemplate(String message, String cause) {
        this.message = message;
        this.cause = cause;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return cause;
    }
}
