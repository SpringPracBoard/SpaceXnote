package com.example.spacexnote.entity;

import com.example.spacexnote.dto.CommentRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends Timestamped {
    //timestamped 상속으로 생성, 수정 시간 자동 생성

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long Id;
    //commentId값 자동 생성.

//    @Column(nullable = false)
//    private String memberName;
//    //Token에서 사용자 정보 파라미터로 받아주기.

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private String comment;

//    @Column(nullable = false)
//    private LocalDateTime createdAt;


    public Comment(CommentRequestDto commentRequestDto) {
//        this.commentId = commentRequestDto.getCommentId();
//        this.memberName = commentDto.getmemberName();
        this.comment = commentRequestDto.getComment();
//        this.createdAt = commentRequestDto.getCreatedAt();
    }
    //Comment 생성자.

    public void update(CommentRequestDto commentRequestDto) {
//        this.commentId = commentRequestDto.getCommentId();
//        this.memberName = commentDto.getmemberName();
        this.comment = commentRequestDto.getComment();
//        this.createdAt = commentRequestDto.getCreatedAt();
    }



}
