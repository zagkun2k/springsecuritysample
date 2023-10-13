package com.example.springsecurity.controller.UserInfo;

import com.example.springsecurity.model.dto.UserInfoDTO;
import com.example.springsecurity.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
@Scope("prototype")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/get/{Id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<UserInfoDTO> getUserById(@PathVariable(name = "Id") Long Id) {

        UserInfoDTO dto = userInfoService.getUserById(Id);
        return ResponseEntity.ok(dto);

    }

    @RequestMapping(value = "/hellouser", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<String> testingUser () {

        return ResponseEntity.ok("admin testing ok!!");

    }
}
