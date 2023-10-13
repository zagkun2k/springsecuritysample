package com.example.springsecurity.controller.UserInfo;

import com.example.springsecurity.common.utils.UserInfoMapper;
import com.example.springsecurity.model.dto.UserInfoDTO;
import com.example.springsecurity.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@Scope("prototype")
public class AdminController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/alluser", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<UserInfoDTO>> getAllListUser() {

        List<UserInfoDTO> userInfoDTOS = userInfoService.getAllUser();
        return ResponseEntity.ok(userInfoDTOS);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestBody UserInfoDTO dto) {

        userInfoService.addUser(UserInfoMapper.UserInfoDTOtoEntity(dto));
        return ResponseEntity.ok("add worked!");

    }

    @RequestMapping(value = "/helloadmin", method = RequestMethod.GET)
    public ResponseEntity<String> testingAdmin () {

        return ResponseEntity.ok("admin testing ok!!");

    }
}
