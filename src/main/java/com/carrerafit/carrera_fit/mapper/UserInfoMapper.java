package com.carrerafit.carrera_fit.mapper;

import com.carrerafit.carrera_fit.dto.UserInfoDto;
import com.carrerafit.carrera_fit.entity.UserInfo;

public class UserInfoMapper {

    public static UserInfoDto toDto(UserInfo userInfo){
        return new UserInfoDto(userInfo.getUserName(), userInfo.getPassword(), userInfo.getRoles());
    }

    public static UserInfo toEntity(UserInfoDto userInfoDto){
        return new UserInfo(userInfoDto.userName(), userInfoDto.password(), userInfoDto.roles());
    }

}
