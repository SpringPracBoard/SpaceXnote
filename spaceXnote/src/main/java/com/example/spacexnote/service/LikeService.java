package com.example.spacexnote.service;

import com.example.spacexnote.entity.Like;
import com.example.spacexnote.entity.Member;
import com.example.spacexnote.entity.Post;
import com.example.spacexnote.repository.LikeRepository;
import com.example.spacexnote.repository.MemberRepository;
import com.example.spacexnote.repository.PostRepository;
import com.example.spacexnote.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final LikeRepository likeRepository;

    @Autowired
    public LikeService(PostRepository postRepository, MemberRepository memberRepository, LikeRepository likeRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
        this.likeRepository = likeRepository;
    }

    public void ClickLike(Long postId, UserDetailsImpl userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername()).orElseThrow(
                () -> new IllegalArgumentException("유저가 없습니다. 돌아가세요.")
        );
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. 돌아가세요.")
        );

        Optional<Like> optionalLike = likeRepository.findByPostAndMember(post, member);

        if (optionalLike.isPresent()){
            likeRepository.delete(optionalLike.get());
        }else{
            Like like = new Like(member, post);
            likeRepository.save(like);
        }

    }
}