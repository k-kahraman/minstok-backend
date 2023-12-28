package com.minstok.minstokbackend.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginDto {
    private String username;
    private String password;
}
