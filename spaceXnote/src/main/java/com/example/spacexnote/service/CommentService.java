package com.example.spacexnote.service;

import com.example.spacexnote.dto.CommentListResponseDto;
import com.example.spacexnote.dto.CommentRequestDto;
import com.example.spacexnote.dto.CommentResponseDto;
import com.example.spacexnote.entity.Comment;
import com.example.spacexnote.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    //댓글 생성해주는 메소드.
//    public CommentRequestDto commentDto(Long commentId) {
//        Comment comment = commentRepository.findById(commentId).orElse(null);
//
//        CommentRequestDto commentRequestDto = new CommentRequestDto(comment.getComment());
//
//        return commentRequestDto;
//    }


    @Transactional
    public Long update(Long commentId, CommentRequestDto commentRequestDto) throws Exception {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );

//        if (!requestDto.getPassword().equals(board.getPassword())) {
//            throw new Exception("비밀번호가 일치하지 않습니다.");
//        } //exception으로 false일 경우 아예 이 위치 밖으로 내보냄. 즉, service에서 쫒겨나서 Controller로 감.
        comment.update(commentRequestDto);
        return comment.getCommentId();
    }


    //Comment 전체 list 변환해서 반환해주는 메소드.
    public CommentListResponseDto commentList() {

        CommentListResponseDto commentListResponseDto = new CommentListResponseDto();

        List<Comment> comments = new ArrayList<>();
        for (Comment comment : comments) {

            commentListResponseDto.show(new CommentResponseDto(comment));
        }

        return commentListResponseDto;
    }


    //Comment 1개 보여주기.
    public ResponseEntity<CommentResponseDto> comment(Long commentId) {
        System.out.println("commentId = " + commentId);

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );

        return ResponseEntity.ok(new CommentResponseDto(comment));
    }
}
