package com.example.spacexnote.dto;

import com.example.spacexnote.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {

    private String membername;

    private String email;


    public MemberResponseDto(Member member){
        this.membername = member.getMembername();
        this.email = member.getEmail();
    }

}
