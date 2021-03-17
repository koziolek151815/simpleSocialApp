package com.socialapp.demo.repo;


import com.socialapp.demo.model.VotePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotePostRepository extends JpaRepository<VotePost,Long> {

}
