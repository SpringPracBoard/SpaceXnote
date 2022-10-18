package com.example.spacexnote.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentDto {

    private long commentId;
    private String comment;
    private LocalDateTime modifiedAt;

    public CommentDto (long commentId, String comment, LocalDateTime modifiedAt) {
        this.commentId = commentId;
        this.comment = comment;
        this.modifiedAt = modifiedAt;
    }

}
