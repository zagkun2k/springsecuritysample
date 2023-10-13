package com.example.springsecurity.common.utils;

import com.example.springsecurity.model.dto.UserInfoDTO;
import com.example.springsecurity.model.entity.UserInfoEntity;
import org.modelmapper.ModelMapper;

public class UserInfoMapper {

    private static final ModelMapper mapper = new ModelMapper();

    public static UserInfoEntity UserInfoDTOtoEntity(UserInfoDTO dto) {

        return mapper.map(dto, UserInfoEntity.class);

    }

    public static UserInfoDTO UserInfoEntityToDTO(UserInfoEntity entity) {

        return mapper.map(entity, UserInfoDTO.class);

    }
}
