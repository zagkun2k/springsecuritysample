package com.example.springsecurity.serviceimpl;

import com.example.springsecurity.common.utils.UserInfoMapper;
import com.example.springsecurity.config.UserInfoUserDetails;
import com.example.springsecurity.model.dto.UserInfoDTO;
import com.example.springsecurity.model.entity.UserInfoEntity;
import com.example.springsecurity.repository.UserInfoRepository;
import com.example.springsecurity.service.UserInfoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.springsecurity.common.constant.UserInfoConst.USER_NOT_FOUND;

@Service
@Transactional(rollbackFor = Exception.class)
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public List<UserInfoDTO> getAllUser() {

        List<UserInfoDTO> userInfoDTOS = new ArrayList<>();
        for (UserInfoEntity entity : userInfoRepository.findAll()) {

            userInfoDTOS.add(UserInfoMapper.UserInfoEntityToDTO(entity));
        }
        return userInfoDTOS;

    }

    @Override
    public UserInfoDTO getUserById(Long Id) {

        return UserInfoMapper
                .UserInfoEntityToDTO(
                        userInfoRepository.findById(Id).get()
                );

    }

    @Override
    public void addUser(UserInfoEntity entity) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        userInfoRepository.save(entity);

    }

}
