package com.socialapp.demo.service;

import com.socialapp.demo.dto.VotePostRequestDto;
import com.socialapp.demo.dto.VotePostResponseDto;
import com.socialapp.demo.mapper.VoteMapper;
import com.socialapp.demo.model.Post;
import com.socialapp.demo.model.User;
import com.socialapp.demo.model.VotePost;
import com.socialapp.demo.repo.PostRepository;
import com.socialapp.demo.repo.VotePostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService {
    private final VotePostRepository votePostRepository;
    private final UserService userService;
    private final PostRepository postRepository;
    private final VoteMapper voteMapper;
    public VoteService(VotePostRepository votePostRepository, UserService userService, PostRepository postRepository, VoteMapper voteMapper) {
        this.votePostRepository = votePostRepository;
        this.userService = userService;
        this.postRepository = postRepository;
        this.voteMapper = voteMapper;
    }

    public VotePostResponseDto votePost(VotePostRequestDto votePostRequestDto, Long postId) {
        User user = userService.getCurrentUser();
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Optional<VotePost> votePostOptional = votePostRepository.findVotePostByPostAndUser(post,user);
        Boolean isLike = votePostRequestDto.getIsLike();
        if(votePostOptional.isPresent()){
            VotePost votePost = votePostOptional.get();
            Boolean isLiked = votePost.isLike();
            if (isLike == isLiked){
                votePostRepository.delete(votePost);
                return voteMapper.mapToVotePostResponseDto(votePost);
            }
            else {throw new RuntimeException("Delete your previous vote");}
        }
        else{
        VotePost addedVote = voteMapper.mapToVotePost(votePostRequestDto,post,user);
        return voteMapper.mapToVotePostResponseDto(votePostRepository.save(addedVote));
        }
    }
}
