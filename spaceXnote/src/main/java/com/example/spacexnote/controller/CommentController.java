package com.example.spacexnote.controller;

import com.example.spacexnote.dto.CommentDto;
import com.example.spacexnote.service.CommentService;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
@NoArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;
    //CommentService에서 나오는 데이터를 불변값으로 받아옴.


    //댓글 추가
    @PostMapping("/post/{postId}/comment")
    public CommentDto createcomment(@PathParam(Long postId), @RequestBody CommentDto commentDto) {
        Comment comment = new Comment(CommentDto);
        return comment;
    }

    //댓글 보여주기

    //댓글 수정

    //댓글 삭제


}
