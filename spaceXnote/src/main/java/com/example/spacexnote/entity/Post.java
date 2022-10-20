package com.example.spacexnote.entity;


import com.example.spacexnote.dto.PostRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String membername;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany
    @JoinColumn(name = "like_id", nullable = false)
    private List<Like> likeList = new ArrayList<>();

    public void addLike(Like like) {
        this.likeList.add(like);
    }

    public void update(PostRequestDto requestDto, Member member) {
        if(!membername.equals(member.getMembername())){
            System.out.println("requestDto = " + membername + ", member = " + member.getMembername());
          throw new RuntimeException("이름이 일치하지 않습니다.");
        }
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}

