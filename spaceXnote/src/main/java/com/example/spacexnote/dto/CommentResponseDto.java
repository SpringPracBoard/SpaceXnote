package com.example.spacexnote.dto;

import com.example.spacexnote.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private long commentId;
    private String comment;
    private LocalDateTime createdAt;

    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.comment = comment.getComment();
        this.createdAt = comment.getCreatedAt();
    }
}
