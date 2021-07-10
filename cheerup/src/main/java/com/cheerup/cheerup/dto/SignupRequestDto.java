package com.cheerup.cheerup.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String password2;
    private boolean admin = false;
    private String adminToken = "";
}