package com.example.spacexnote.entity;


import com.example.spacexnote.dto.PostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    public void update(PostRequestDto requestDto, Member member) {
        if(!membername.equals(member.getMembername())){
            System.out.println("requestDto = " + membername + ", member = " + member.getMembername());
          throw new RuntimeException("이름이 일치하지 않습니다.");
        }
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}

