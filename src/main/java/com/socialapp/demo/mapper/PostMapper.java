package com.socialapp.demo.mapper;


import com.socialapp.demo.dto.PostRequestDto;
import com.socialapp.demo.dto.PostResponseDto;
import com.socialapp.demo.model.Post;
import com.socialapp.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
@Repository
public abstract class PostMapper {

    @Mapping(target = "user", source = "user")
    @Mapping(target = "date",  expression = "java(LocalDateTime.now())")
    public abstract Post mapToPost(PostRequestDto postRequestDto, User user);

    @Mapping(target = "username", source = "post.user.username")
    public abstract PostResponseDto mapToPostResponseDto(Post post);




}
