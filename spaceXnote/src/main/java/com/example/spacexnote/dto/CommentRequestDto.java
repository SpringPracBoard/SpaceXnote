package com.example.spacexnote.dto;

import com.example.spacexnote.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentRequestDto {
    private Long postId;

    private String comment;

//    public CommentRequestDto(String comment) {
//        this.commentId = commentId;
//        this.comment = comment;
////        this.createdAt = createdAt;
//    }

    public void createComment (Comment comment) {
//        this.commentId = comment.getCommentId();
        this.comment = comment.getComment();
//        this.createdAt = comment.getCreatedAt();
    }

}
