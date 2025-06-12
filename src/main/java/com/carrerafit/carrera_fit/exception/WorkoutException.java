package com.carrerafit.carrera_fit.exception;

import org.springframework.http.HttpStatus;

public class WorkoutException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public WorkoutException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }
    public Throwable geThrowable() {
        return throwable;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    
}
