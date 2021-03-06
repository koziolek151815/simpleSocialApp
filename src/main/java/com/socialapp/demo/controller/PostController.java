package com.socialapp.demo.controller;


import com.socialapp.demo.dto.PostRequestDto;
import com.socialapp.demo.dto.PostResponseDto;
import com.socialapp.demo.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<PostResponseDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/posts")
    PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }

    @GetMapping("/posts/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/posts/{id}")
    PostResponseDto updatePost(@RequestBody PostRequestDto postRequestDto, @PathVariable Long id) {

        return postService.updatePost(postRequestDto,id);
    }
    @DeleteMapping("/posts/{id}")
    void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
