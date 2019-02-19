package com.demo.restservice.restservicedemohateoas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchProductException extends RuntimeException {

    public NoSuchProductException() {
    }

    public NoSuchProductException(String message) {
        super(message);
    }

    public NoSuchProductException(Throwable cause) {
        super(cause);
    }
}
