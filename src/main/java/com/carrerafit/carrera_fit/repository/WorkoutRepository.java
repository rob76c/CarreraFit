package com.carrerafit.carrera_fit.repository;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import com.carrerafit.carrera_fit.entity.Workout;

public interface WorkoutRepository extends MongoRepository<Workout, String> {

    @Query("{workoutId : '?0'}")
    Workout findWorkoutByWorkoutId(String workoutId);

    @Query(value = "{ 'workoutId' : { $eq : ?0} }")
    @Update(pipeline = { " { '$set' : {'name' : ?1}}" })
    void updateWorkoutNameByWorkoutId(String workoutId, String name);

    @DeleteQuery
    void deleteWorkoutByWorkoutId(String workoutId);
}

