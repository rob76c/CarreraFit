package com.carrerafit.carrera_fit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carrerafit.carrera_fit.dto.UserInfoDto;
import com.carrerafit.carrera_fit.entity.UserInfo;
import com.carrerafit.carrera_fit.mapper.UserInfoMapper;
import com.carrerafit.carrera_fit.repository.UserInfoRepository;
import com.carrerafit.carrera_fit.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public UserInfoDto createUser(UserInfoDto userInfoDto) {
        UserInfo userInfo = UserInfoMapper.toEntity(userInfoDto);
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return UserInfoMapper.toDto(userInfo);
    }



}
