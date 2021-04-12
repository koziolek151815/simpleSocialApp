package com.socialapp.demo;

import com.socialapp.demo.controller.PostController;
import com.socialapp.demo.dto.PostResponseDto;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PostControllerTest {
    @Test
    public void getPosts(){
        PostController postController= mock(PostController.class);
        when(postController.getAllPosts()).thenReturn(giveData());
        Assert.assertThat(postController.getAllPosts(), Matchers.hasSize(1));
    }
public List<PostResponseDto> giveData(){
        List<PostResponseDto> postResponseDtoList= new ArrayList<>();
        postResponseDtoList.add(new PostResponseDto((long) 1,"jd", LocalDateTime.now(),"edzio"));
        return postResponseDtoList;
    }
}
