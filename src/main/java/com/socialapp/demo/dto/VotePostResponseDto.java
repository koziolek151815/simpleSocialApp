package com.socialapp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class VotePostResponseDto {
    private Long id;
    private Boolean isLike;
    private Long postId;
    private String userName;

}
