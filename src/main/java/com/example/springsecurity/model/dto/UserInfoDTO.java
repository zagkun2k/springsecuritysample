package com.example.springsecurity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO implements Serializable {

    private Long Id;
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean active;
    private boolean locked;

}
