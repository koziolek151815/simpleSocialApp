package com.socialapp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String text;
    private LocalDateTime date;
    private String username;
}
