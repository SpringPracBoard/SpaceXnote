package com.example.spacexnote.service;

import com.example.spacexnote.dto.CommentResponseDto;
import com.example.spacexnote.dto.PostRequestDto;
import com.example.spacexnote.dto.PostResponseDto;
import com.example.spacexnote.entity.Comment;
import com.example.spacexnote.entity.Member;
import com.example.spacexnote.entity.Post;
import com.example.spacexnote.repository.CommentRepository;
import com.example.spacexnote.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    public ResponseEntity<List<PostResponseDto>> index() {

        List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        if (posts.isEmpty()) {
            throw new RuntimeException("게시글이 없습니다.");
        }

        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        for (int i = 0; i < posts.size(); i++) {
            postResponseDtoList.add(new PostResponseDto(posts.get(i)));
        }
        return new ResponseEntity<>(postResponseDtoList, HttpStatus.OK);
    }


    public ResponseEntity<PostResponseDto> create(PostRequestDto postRequestDto, Member member) {

        System.out.println("postRequestDto = " + postRequestDto + ", member = " + member);
        Post post = Post.builder()
                .title(postRequestDto.getTitle())
                .content(postRequestDto.getContent())
                .membername(member.getMembername())
                .member(member)
                .build();

        PostResponseDto postResponseDto = new PostResponseDto(postRepository.save(post));
        return new ResponseEntity<>(postResponseDto, HttpStatus.OK);
    }

    public ResponseEntity<PostResponseDto> show(Long id) {

        Post post = postRepository.findById(id).orElseThrow(
                () -> new RuntimeException("해당 게시물이 없습니다.")
        );

        PostResponseDto postResponseDto = new PostResponseDto(post);

        List<Comment> comments = commentRepository.findAllByPost_Id(id);
        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();

        for (Comment c : comments) {
            commentResponseDtoList.add(new CommentResponseDto(c));
        }
        postResponseDto.updateCommentDtoList(commentResponseDtoList);

        return new ResponseEntity<>(postResponseDto, HttpStatus.OK);

    }

    public ResponseEntity<String> delete(Long id, Member member) {

        Post post = postRepository.findById(id).orElseThrow(
                () -> new RuntimeException("삭제할 게시물이 없습니다.")
        );

        if (!post.getMember().getMembername().equals(member.getMembername())) {
            throw new RuntimeException("본인만 삭제 가능합니다.");
        }

        postRepository.delete(post);
        return new ResponseEntity<>("삭제 완료", HttpStatus.OK);

    }

    public ResponseEntity<PostResponseDto> update(Long id, PostRequestDto requestDto, Member member) {

        postRepository.existsPostById(id);

        Post post = postRepository.findById(id).orElseThrow(
                () -> new RuntimeException("수정할 게시물이 없습니다.")
        );

        post.update(requestDto, member);

        PostResponseDto postResponseDto = new PostResponseDto(postRepository.save(post));

        return new ResponseEntity<>(postResponseDto, HttpStatus.OK);
    }
}

