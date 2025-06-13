package com.carrerafit.carrera_fit.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carrerafit.carrera_fit.entity.UserInfo;
import com.carrerafit.carrera_fit.mapper.UserDetailsMapper;
import com.carrerafit.carrera_fit.repository.UserInfoRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByUserName(username);

        return userInfo.map(UserDetailsMapper::new)
            .orElseThrow(() -> new UsernameNotFoundException("User "+ username + " Not Found"));
    }

}
