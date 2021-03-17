package com.socialapp.demo.controller;

import com.socialapp.demo.dto.CommentRequestDto;
import com.socialapp.demo.dto.CommentResponseDto;
import com.socialapp.demo.dto.PostRequestDto;
import com.socialapp.demo.dto.PostResponseDto;
import com.socialapp.demo.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/posts/{postId}/comments")
    List<CommentResponseDto> getAllCommentsForPost(@PathVariable Long postId) {
        return commentService.getAllCommentsForPost(postId);
    }

    @PostMapping("/posts/{postId}/comments")
    CommentResponseDto createCommentForPost(@RequestBody CommentRequestDto commentRequestDto, @PathVariable Long postId) {
        return commentService.createCommentForPost(commentRequestDto,postId);
    }
}
