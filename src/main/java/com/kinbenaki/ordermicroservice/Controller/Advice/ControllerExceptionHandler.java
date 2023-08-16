package com.kinbenaki.ordermicroservice.Controller.Advice;

import com.kinbenaki.ordermicroservice.Exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundException> handleProductNotFoundException(ProductNotFoundException ex) {
        ProductNotFoundException errorResponse = new ProductNotFoundException(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}

