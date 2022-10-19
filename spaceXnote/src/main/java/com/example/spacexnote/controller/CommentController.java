package com.example.spacexnote.controller;

import com.example.spacexnote.dto.CommentListResponseDto;
import com.example.spacexnote.dto.CommentRequestDto;
import com.example.spacexnote.dto.CommentResponseDto;
import com.example.spacexnote.entity.Comment;
import com.example.spacexnote.repository.CommentRepository;
import com.example.spacexnote.security.UserDetailsImpl;
import com.example.spacexnote.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;
    //CommentService에서 나오는 데이터를 불변값으로 받아옴.

    private final CommentRepository commentRepository;


    //댓글 추가
//    @PostMapping("/post/{postId}/comment")
    @PostMapping("/post/comment")
    public Comment createComment(@RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        Comment comment = new Comment(commentRequestDto);
        return commentService.create(commentRequestDto, userDetails.getMember());

    }

    //댓글 전체 보여주기
    @GetMapping("/post/comment") //read (게시글 작성쪽 양식 가져오는 get요청)
    public CommentListResponseDto commentList() {

        return commentService.commentList();
    }

    //댓글 하나 보여주기
    @GetMapping("post/{commentId}") //read
    public ResponseEntity<CommentResponseDto> comment(@PathVariable Long commentId) {
        return commentService.comment(commentId);
    }

    //댓글 수정
    @PutMapping("/post/{commentId}")
    public Long updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto) throws Exception {
        commentService.update(commentId, commentRequestDto);
        return commentId;
    }


    //댓글 삭제
    @DeleteMapping("/post/{commentId}")
    public Long deleteBoard(@PathVariable Long commentId) {
        commentRepository.deleteById(commentId);
        return commentId;
    }



}
