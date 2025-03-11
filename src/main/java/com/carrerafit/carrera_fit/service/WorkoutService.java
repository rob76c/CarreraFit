package com.carrerafit.carrera_fit.service;

import java.util.List;

import com.carrerafit.carrera_fit.dto.WorkoutDto;

public interface WorkoutService {

    public WorkoutDto getWorkout(String workoutId);

    public List<WorkoutDto> getAllWorkouts();

    public WorkoutDto createWorkout(WorkoutDto workoutDto);

    public WorkoutDto updateWorkoutName(WorkoutDto workoutDto);

    public void deleteWorkoutByWorkoutId(String workoutId);
}
