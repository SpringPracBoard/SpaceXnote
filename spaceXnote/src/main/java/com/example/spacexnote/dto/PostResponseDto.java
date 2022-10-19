package com.example.spacexnote.dto;


import com.example.spacexnote.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {

    private Long id;

    private String memberName;

    private String title;

    private String content;

    private List<CommentResponseDto> commentResponseDtoList;

    private LocalDateTime createdAt;

    public PostResponseDto(Post post) {
        id = post.getId();
        memberName = post.getMembername();
        title = post.getTitle();
        content = post.getContent();
        createdAt = post.getCreatedAt();

    }

    public void updateCommentDtoList(List<CommentResponseDto> commentResponseDtoList) {
        this.commentResponseDtoList = commentResponseDtoList;
    }


}
