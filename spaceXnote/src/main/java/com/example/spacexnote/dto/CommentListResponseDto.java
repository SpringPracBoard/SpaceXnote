package com.example.spacexnote.dto;

import java.util.LinkedList;
import java.util.List;

public class CommentListResponseDto {
List<CommentResponseDto> commentResponseDtos = new LinkedList<>();

public void show (CommentResponseDto commentResponseDto) {
    commentResponseDtos.add(commentResponseDto);
}


}
