package com.carrerafit.carrera_fit.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carrerafit.carrera_fit.entity.UserInfo;

public interface UserInfoRepository extends MongoRepository<UserInfo, String>{

   Optional<UserInfo> findByUserName(String userName);

}
