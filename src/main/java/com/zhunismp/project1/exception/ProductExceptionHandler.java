package com.zhunismp.project1.exception;

import com.zhunismp.project1.response.ExceptionResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {
    @ExceptionHandler(value = {ProductNotFoundException.class})
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        // create payload
        ExceptionResponseHandler exceptionResponse = new ExceptionResponseHandler(
                productNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }
}
