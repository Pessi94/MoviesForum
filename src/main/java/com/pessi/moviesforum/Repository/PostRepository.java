package com.pessi.moviesforum.Repository;

import com.pessi.moviesforum.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
