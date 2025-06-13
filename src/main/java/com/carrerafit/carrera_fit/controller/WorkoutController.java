package com.carrerafit.carrera_fit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.carrerafit.carrera_fit.dto.WorkoutDto;
import com.carrerafit.carrera_fit.service.WorkoutService;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService)
    {
        this.workoutService = workoutService;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String>welcomeMessage()
    {
        return new ResponseEntity<>("Welcome to the workouts", HttpStatus.OK);
    }

    @GetMapping("/{workoutId}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<WorkoutDto> getWorkout(@PathVariable String workoutId)
    {

        WorkoutDto workoutDto = workoutService.getWorkout(workoutId);
        return new ResponseEntity<>( workoutDto, HttpStatus.OK);
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<WorkoutDto>> getAllWorkouts()
    {
        List<WorkoutDto> workoutDtoList = workoutService.getAllWorkouts();
        return new ResponseEntity<>(workoutDtoList, HttpStatus.OK);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    //todo add security feature to restrict anyone from creating with the same id, just make a unique id
    public ResponseEntity<WorkoutDto> createWorkouts(@RequestBody WorkoutDto workoutDto)
    {
        WorkoutDto workoutDtoCreate = workoutService.createWorkout(workoutDto);
        return new ResponseEntity<>(workoutDtoCreate, HttpStatus.OK);
    }

    @PutMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<WorkoutDto> updateWorkout(@RequestBody WorkoutDto workoutDto)
    {
        WorkoutDto workoutDtoUpdate = workoutService.updateWorkoutName(workoutDto);
        return new ResponseEntity<>(workoutDtoUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{workoutId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteWorkout (@PathVariable String workoutId)
    {
        workoutService.deleteWorkoutByWorkoutId(workoutId);
        return new ResponseEntity<>("Workout Deleted Successfully"+ workoutId, HttpStatus.OK);
    }
}
