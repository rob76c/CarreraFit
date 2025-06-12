package com.carrerafit.carrera_fit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.carrerafit.carrera_fit.dto.WorkoutDto;
import com.carrerafit.carrera_fit.entity.Workout;
import com.carrerafit.carrera_fit.exception.WorkoutNotFoundException;
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
        if(workoutRepository.findWorkoutByWorkoutId(workoutId)==null)
        {
            throw new WorkoutNotFoundException("Requested workout does not exist");
        }
        Workout workout = workoutRepository.findWorkoutByWorkoutId(workoutId);
        WorkoutDto workoutDto = WorkoutMapper.toDto(workout);
        return workoutDto;
        
    }

    @Override
    public List<WorkoutDto> getAllWorkouts() {
        //todo: what if list is empty??
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
        //todo: add checks for parameters to be correct
        Workout workout = workoutRepository.insert(WorkoutMapper.toEntity(workoutDto));
        return WorkoutMapper.toDto(workout);
    }

    //todo: Change to update full workout parameters not just name
    @Override
    public WorkoutDto updateWorkoutName(WorkoutDto workoutDto) {
        if(workoutRepository.findWorkoutByWorkoutId(workoutDto.workoutId())==null)
        {
            throw new WorkoutNotFoundException("Requested workout does not exist");
        }
        workoutRepository.updateWorkoutNameByWorkoutId(workoutDto.workoutId(), workoutDto.name());
        Workout workout = workoutRepository.findWorkoutByWorkoutId(workoutDto.workoutId());
        return WorkoutMapper.toDto(workout);
    }

    @Override
    public void deleteWorkoutByWorkoutId(String workoutId) {
        if(workoutRepository.findWorkoutByWorkoutId(workoutId)==null)
        {
            throw new WorkoutNotFoundException("Requested workout does not exist");
        }
        workoutRepository.deleteWorkoutByWorkoutId(workoutId);
    }

}
