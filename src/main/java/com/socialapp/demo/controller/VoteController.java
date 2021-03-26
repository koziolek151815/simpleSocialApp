package com.socialapp.demo.controller;

import com.socialapp.demo.dto.PostRequestDto;
import com.socialapp.demo.dto.PostResponseDto;
import com.socialapp.demo.dto.VotePostRequestDto;
import com.socialapp.demo.dto.VotePostResponseDto;
import com.socialapp.demo.service.VoteService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class VoteController {
    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }
    @PostMapping("/posts/{id}/vote")
    VotePostResponseDto votePost(@RequestBody VotePostRequestDto votePostRequestDto, @PathVariable Long id) {
        return voteService.votePost(votePostRequestDto,id);
    }
}
