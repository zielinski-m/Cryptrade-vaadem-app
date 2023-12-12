package com.cryptrade.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CryptocurrencyNotFoundException.class)
    public ResponseEntity<Object> handleCryptocurrencyFoundException(CryptocurrencyNotFoundException exception) {
        return new ResponseEntity<>("Cryptocurrency with given id does not exist", HttpStatus.BAD_REQUEST);
    }
}
