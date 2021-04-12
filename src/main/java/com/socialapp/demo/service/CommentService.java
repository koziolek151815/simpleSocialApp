package com.socialapp.demo.service;

import com.socialapp.demo.dto.CommentRequestDto;
import com.socialapp.demo.dto.CommentResponseDto;
import com.socialapp.demo.dto.PostRequestDto;
import com.socialapp.demo.dto.PostResponseDto;
import com.socialapp.demo.mapper.CommentMapper;
import com.socialapp.demo.model.Comment;
import com.socialapp.demo.model.Post;
import com.socialapp.demo.model.User;
import com.socialapp.demo.repo.CommentRepository;
import com.socialapp.demo.repo.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final PostRepository postRepository;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper, PostRepository postRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<CommentResponseDto> getAllCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId).get();
        return commentRepository.findCommentsByPostId(postId)
                .stream()
                .map(commentMapper::mapToCommentResponseDto)
                .collect(toList());
    }

    public CommentResponseDto createCommentForPost(CommentRequestDto commentRequestDto, Long postId) {

        User user = userService.getCurrentUser();
        Post post = postRepository.findById(postId).get();
        Comment comment = commentRepository.save(commentMapper.mapToComment(commentRequestDto, user, post));
        return commentMapper.mapToCommentResponseDto(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public CommentResponseDto updateComment(CommentRequestDto commentRequestDto, Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("No found such comment"));
        comment.setText(commentRequestDto.getText());
        commentRepository.save(comment);
        return commentMapper.mapToCommentResponseDto(comment);
    }
}
