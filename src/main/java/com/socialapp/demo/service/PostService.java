package com.socialapp.demo.service;


import com.socialapp.demo.dto.PostRequestDto;
import com.socialapp.demo.dto.PostResponseDto;
import com.socialapp.demo.mapper.PostMapper;
import com.socialapp.demo.model.Post;
import com.socialapp.demo.model.User;
import com.socialapp.demo.repo.PostRepository;
import com.socialapp.demo.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserRepository userRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, PostMapper postMapper, UserRepository userRepository, UserService userService) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.userRepository = userRepository;
        this.userService = userService;
    }
    public List<PostResponseDto> getAllPosts(){
        User user = userService.getCurrentUser();
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToPostResponseDto)
                .collect(toList());

    }

    public PostResponseDto getPost(Long id){
        User user = userService.getCurrentUser();
        return postMapper.mapToPostResponseDto(postRepository.findById(id).get());
    }
    public PostResponseDto createPost(PostRequestDto postRequestDto){

        User user = userService.getCurrentUser();
        Post post = postRepository.save(postMapper.mapToPost(postRequestDto,user));
        return postMapper.mapToPostResponseDto(post);
    }

    public PostResponseDto updatePost(PostRequestDto postRequestDto, Long id){

        Post oldPost = postRepository.findById(id).get();
        oldPost.setText(postRequestDto.getText());
        postRepository.save(oldPost);

        return postMapper.mapToPostResponseDto(oldPost);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
