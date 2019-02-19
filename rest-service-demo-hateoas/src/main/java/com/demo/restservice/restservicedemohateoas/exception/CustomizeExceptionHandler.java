package com.demo.restservice.restservicedemohateoas.exception;

import com.demo.restservice.restservicedemohateoas.exception.NoSuchProductException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RestController
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            NoSuchProductException.class
    })
    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        if(ex instanceof NoSuchProductException) {
            ExceptionTemplate template = new ExceptionTemplate(ex.getMessage(),ex.getCause().toString());
            return new ResponseEntity(template, HttpStatus.NOT_FOUND);
        }
        else
            throw new Exception();
    }


}
