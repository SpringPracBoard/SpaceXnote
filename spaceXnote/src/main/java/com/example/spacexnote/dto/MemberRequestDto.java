package com.example.spacexnote.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class MemberRequestDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String membername;

    public MemberRequestDto(String email, String password, String membername) {
        this.email = email;
        this.password = password;
        this.membername = membername;
    }

    //비밀번호 암호화
    public void setEncodePwd(String encodePwd) {
        this.password = encodePwd;
    }


}
