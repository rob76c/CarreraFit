package com.carrerafit.carrera_fit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    @GetMapping("/{workoutId}")
    public ResponseEntity<String> getWorkout(@PathVariable String workoutId)
    {
        return new ResponseEntity<>( "Workout Found" +" " +workoutId, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<String>> getAllWorkouts()
    {
        List<String> workouts = new ArrayList<>();
        workouts.add("Chest Press");
        workouts.add("Arnold Curl");
        workouts.add("Tricep Extention");

        return new ResponseEntity<>(workouts, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> createWorkouts(String workout)
    {
        return new ResponseEntity<>("Workout Created", HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateWorkout(String workout)
    {
        return new ResponseEntity<>("Book Updated", HttpStatus.OK);
    }

    @DeleteMapping("/{workoutId}")
    public ResponseEntity<String> deleteBook(@PathVariable String workoutId)
    {
        return new ResponseEntity<>("Workout Deleted Successfully"+ workoutId, HttpStatus.OK);
    }
}
