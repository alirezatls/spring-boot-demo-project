package com.demo.restservice.restservicedemohateoas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchCategoryException extends RuntimeException {

    public NoSuchCategoryException() {
    }

    public NoSuchCategoryException(String message) {
        super(message);
    }
}
