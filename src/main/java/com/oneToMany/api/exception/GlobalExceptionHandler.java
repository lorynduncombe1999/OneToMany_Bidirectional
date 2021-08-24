package com.oneToMany.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
//These are the error that may be thrown while navigating this API the first exception is commented
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> dataNotFound(DataNotFoundException ex, WebRequest request){
        //creates an errorDetails variable which stores the Date, message, and description of the error to send to person reciveing the error message
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));
               //returns the response entity with the error details and specifies the tyep of error (not found)
                return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalException(Exception e, WebRequest request){
       ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(),request.getDescription(false));
       return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
