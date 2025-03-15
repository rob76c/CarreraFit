package com.carrerafit.carrera_fit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.carrerafit.carrera_fit.dto.WorkoutDto;
import com.carrerafit.carrera_fit.entity.Workout;
import com.carrerafit.carrera_fit.mapper.WorkoutMapper;
import com.carrerafit.carrera_fit.repository.WorkoutRepository;
import com.carrerafit.carrera_fit.service.WorkoutService;

@Service
public class WorkoutServiceImpl implements WorkoutService{

    WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository)
    {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public WorkoutDto getWorkout(String workoutId) {
        Workout workout = workoutRepository.findWorkoutByWorkoutId(workoutId);
        WorkoutDto workoutDto = WorkoutMapper.toDto(workout);
        return workoutDto;
        
    }

    @Override
    public List<WorkoutDto> getAllWorkouts() {
        List<Workout> workouts = workoutRepository.findAll();
        List<WorkoutDto> workoutDtoList = new ArrayList<>();
        for (Workout workout : workouts)
        {
            workoutDtoList.add(WorkoutMapper.toDto(workout));
        }
        return workoutDtoList;
    }

    @Override
    public WorkoutDto createWorkout(WorkoutDto workoutDto) {
        Workout workout = workoutRepository.insert(WorkoutMapper.toEntity(workoutDto));
        return WorkoutMapper.toDto(workout);
    }

    @Override
    public WorkoutDto updateWorkoutName(WorkoutDto workoutDto) {
        workoutRepository.updateWorkoutNameByWorkoutId(workoutDto.workoutId(), workoutDto.name());
        Workout workout = workoutRepository.findWorkoutByWorkoutId(workoutDto.workoutId());
        return WorkoutMapper.toDto(workout);
    }

    @Override
    public void deleteWorkoutByWorkoutId(String workoutId) {
        workoutRepository.deleteWorkoutByWorkoutId(workoutId);
    }

}
