package com.augeregalloydelisle.back.exception;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message)
    {
        super(message);
    }
}
