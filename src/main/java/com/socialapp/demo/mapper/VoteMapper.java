package com.socialapp.demo.mapper;


import com.socialapp.demo.dto.VotePostRequestDto;
import com.socialapp.demo.dto.VotePostResponseDto;
import com.socialapp.demo.model.Post;
import com.socialapp.demo.model.User;
import com.socialapp.demo.model.VotePost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Repository;



@Mapper(componentModel = "spring")
@Repository
public abstract class VoteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "post", source = "post")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "like", source = "votePostRequestDto.isLike")
    public abstract VotePost mapToVotePost(VotePostRequestDto votePostRequestDto, Post post, User user);

    public abstract VotePostResponseDto mapToVotePostResponseDto(VotePost upVotePost);
}
