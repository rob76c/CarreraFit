package com.carrerafit.carrera_fit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WorkoutExceptionHandler {

    @ExceptionHandler(value = {WorkoutNotFoundException.class})
    public ResponseEntity<Object> handleWorkoutNotFoundException(WorkoutNotFoundException workoutNotFoundException) 
    {
        WorkoutException workoutException = new WorkoutException(workoutNotFoundException.getMessage(), workoutNotFoundException.getCause(), HttpStatus.NOT_FOUND);

    return new ResponseEntity<>(workoutException, HttpStatus.NOT_FOUND);
    }

}
