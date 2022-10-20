package com.example.spacexnote.dto;

import com.example.spacexnote.entity.Like;
import lombok.Getter;

@Getter
public class LikeResponseDto {

    private final String email;
    private final String membername;

    public LikeResponseDto(Like like) {
        this.email = like.getMember().getEmail();
        this.membername = like.getMember().getMembername();
    }
}
