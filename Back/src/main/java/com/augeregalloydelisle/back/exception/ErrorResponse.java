package com.augeregalloydelisle.back.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private String message; 
    private HttpStatus status; 
    private Integer code; 
    private ZonedDateTime time;

    public ErrorResponse(String message, HttpStatus status, Integer code, ZonedDateTime time) {
        this.message = message;
        this.status = status;
        this.code = code;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

}
