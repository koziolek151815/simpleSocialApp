package com.socialapp.demo.mapper;


import com.socialapp.demo.dto.CommentRequestDto;
import com.socialapp.demo.dto.CommentResponseDto;
import com.socialapp.demo.model.Comment;
import com.socialapp.demo.model.Post;
import com.socialapp.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
@Repository
public abstract class CommentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "text", source = "commentRequestDto.text")
    @Mapping(target = "post", source = "post")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "date",  expression = "java(LocalDateTime.now())")
    public abstract Comment mapToComment(CommentRequestDto commentRequestDto, User user, Post post);

    @Mapping(target = "username", source = "comment.user.username")
    @Mapping(target = "postId", source = "comment.post.id")
    public abstract CommentResponseDto mapToCommentResponseDto(Comment comment);

}
