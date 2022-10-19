package com.example.spacexnote.controller;


import com.example.spacexnote.dto.PostRequestDto;
import com.example.spacexnote.dto.PostResponseDto;
import com.example.spacexnote.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    // 게시글 전체 조회
    @GetMapping("/posts")
    public ResponseEntity<List<PostResponseDto>> index(){
        return postService.index();
    }


    // 게시글 생성
    @PostMapping("/posts")
    public ResponseEntity<PostResponseDto> create(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDe1tailsImpl userDetails){
        System.out.println("postRequestDto = " + postRequestDto);
        return postService.create(postRequestDto, userDetails.getMember());
    }

    // 특정 게시글 조회
    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponseDto> show(@PathVariable Long id){
        return postService.show(id);
    }

    // 게시글 삭제
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return postService.delete(id, userDetails.getMember());
    }


    // 게시글 수정
    @PutMapping("/posts/{id}")
    public ResponseEntity<PostResponseDto> update(@PathVariable Long id, @RequestBody PostRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
       return postService.update(id, requestDto, userDetails.getMember());
    }

}
