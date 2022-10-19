package com.example.spacexnote.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class LoginReqDto {

    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public LoginReqDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

}

