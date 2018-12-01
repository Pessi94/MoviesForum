package com.pessi.moviesforum.services;

import com.pessi.moviesforum.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
