package com.example.spacexnote.repository;

import com.example.spacexnote.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByOrderByModifiedAtDesc();

    List<Comment>findAllByPost_Id(Long postid);
}
