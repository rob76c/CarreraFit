package com.carrerafit.carrera_fit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{workoutId}")
    public ResponseEntity<WorkoutDto> getWorkout(@PathVariable String workoutId)
    {

        WorkoutDto workoutDto = workoutService.getWorkout(workoutId);
        return new ResponseEntity<>( workoutDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<WorkoutDto>> getAllWorkouts()
    {
        List<WorkoutDto> workoutDtoList = workoutService.getAllWorkouts();
        return new ResponseEntity<>(workoutDtoList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<WorkoutDto> createWorkouts(@RequestBody WorkoutDto workoutDto)
    {
        WorkoutDto workoutDtoCreate = workoutService.createWorkout(workoutDto);
        return new ResponseEntity<>(workoutDtoCreate, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<WorkoutDto> updateWorkout(@RequestBody WorkoutDto workoutDto)
    {
        //todo fix workouts not updating
        WorkoutDto workoutDtoUpdate = workoutService.updateWorkoutName(workoutDto);
        return new ResponseEntity<>(workoutDtoUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{workoutId}")
    public ResponseEntity<String> deleteWorkout (@PathVariable String workoutId)
    {
        workoutService.deleteWorkoutByWorkoutId(workoutId);
        return new ResponseEntity<>("Workout Deleted Successfully"+ workoutId, HttpStatus.OK);
    }
}
