package com.carrerafit.carrera_fit.exception;

public class WorkoutNotFoundException  extends RuntimeException{

    public WorkoutNotFoundException(String message) {
        super(message);
    }

    public WorkoutNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
