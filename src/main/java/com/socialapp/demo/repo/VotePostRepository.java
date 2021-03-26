package com.socialapp.demo.repo;

import com.socialapp.demo.model.Post;
import com.socialapp.demo.model.User;
import com.socialapp.demo.model.VotePost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VotePostRepository extends JpaRepository<VotePost,Long> {
    Optional<VotePost> findVotePostByPostAndUser(Post post, User user);
}
