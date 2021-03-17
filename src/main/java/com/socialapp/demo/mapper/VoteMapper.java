package com.socialapp.demo.mapper;


import com.socialapp.demo.dto.VotePostRequestDto;
import com.socialapp.demo.dto.VotePostResponseDto;
import com.socialapp.demo.model.VotePost;
import org.mapstruct.Mapper;

@Mapper
public interface VoteMapper {
    VotePost mapToVotePost(VotePostRequestDto votePostRequestDto);

    VotePostResponseDto mapToVotePostResponseDto(VotePost votePost);
}
