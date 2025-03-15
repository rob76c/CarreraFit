package com.carrerafit.carrera_fit.mapper;

import com.carrerafit.carrera_fit.dto.WorkoutDto;
import com.carrerafit.carrera_fit.entity.Workout;

public class WorkoutMapper {

    public static WorkoutDto toDto(Workout workout)
    {
        WorkoutDto workoutDto = new WorkoutDto(workout.workoutId(), workout.name(), workout.type(), workout.muscle(),workout.equipment(),workout.difficulty(),workout.instructions(),workout.video());
        return workoutDto;
    }

    public static Workout toEntity(WorkoutDto workoutDto)
    {
        Workout workout = new Workout(workoutDto.workoutId(), workoutDto.name(), workoutDto.type(), workoutDto.muscle(), workoutDto.equipment(), workoutDto.difficulty(), workoutDto.instructions(), workoutDto.video());
        return workout;
    }
}

