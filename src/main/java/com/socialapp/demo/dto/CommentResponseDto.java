package com.socialapp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String text;
    private Long postId;
    private String username;
    private LocalDateTime date;
}
