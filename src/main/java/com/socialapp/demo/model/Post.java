package com.socialapp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;
}
