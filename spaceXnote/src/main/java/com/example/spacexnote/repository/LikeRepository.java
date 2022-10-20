package com.example.spacexnote.repository;

import com.example.spacexnote.entity.Like;
import com.example.spacexnote.entity.Member;
import com.example.spacexnote.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByPostAndMember(Post post, Member member);
}
