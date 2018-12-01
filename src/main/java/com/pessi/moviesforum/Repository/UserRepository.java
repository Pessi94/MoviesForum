package com.pessi.moviesforum.Repository;

import com.pessi.moviesforum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
