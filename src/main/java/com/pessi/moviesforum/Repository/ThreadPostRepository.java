package com.pessi.moviesforum.Repository;

import com.pessi.moviesforum.entity.ThreadPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadPostRepository extends JpaRepository<ThreadPost, Long> {

}
