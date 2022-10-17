package com.example.spacexnote.entity;

import com.example.spacexnote.dto.CommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor

public class Comment extends Timestamped {
    //timestamped 상속으로 생성, 수정 시간 자동 생성

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long commentId;
    //commentId값 자동 생성.

    @Column(nullable = false)
    private String memberName;
    //Token에서 사용자 정보 파라미터로 받아주기.

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private LocalDateTime createdAt;


    public Comment(Long commentId, String memberName, String comment, LocalDateTime createdAt) {
        this.commentId = commentId;
        this.memberName = memberName;
        this.comment = comment;
        this.createdAt = createdAt;
    }
    //Comment 생성자.

    public void update()



}
