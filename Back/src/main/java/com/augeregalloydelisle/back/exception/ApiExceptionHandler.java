package com.augeregalloydelisle.back.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value={BadRequestException.class})
    public ResponseEntity<ErrorResponse> handleExceptionBadRequest(Exception e)
    {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ZonedDateTime.now()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value ={ForbiddenException.class})
    public ResponseEntity<ErrorResponse> handleExceptionForbidden(Exception e)
    {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), HttpStatus.FORBIDDEN,HttpStatus.FORBIDDEN.value(), ZonedDateTime.now()),HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value ={RessourceNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleExceptionNotFound(Exception e)
    {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value(), ZonedDateTime.now()),HttpStatus.NOT_FOUND);
    }

}