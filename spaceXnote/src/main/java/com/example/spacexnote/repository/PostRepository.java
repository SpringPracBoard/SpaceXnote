package com.example.spacexnote.repository;


import com.example.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    boolean existsPostById(Long id);
}
