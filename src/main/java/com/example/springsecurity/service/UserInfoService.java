package com.example.springsecurity.service;

import com.example.springsecurity.model.dto.UserInfoDTO;
import com.example.springsecurity.model.entity.UserInfoEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserInfoService {

    List<UserInfoDTO> getAllUser();
    UserInfoDTO getUserById(Long Id);
    void addUser(UserInfoEntity entity);

}
