package com.pessi.moviesforum.configuration;

import com.pessi.moviesforum.Repository.RoleRepository;
import com.pessi.moviesforum.entity.Role;
import com.pessi.moviesforum.entity.User;
import com.pessi.moviesforum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @PostConstruct
    private void initialize() {
        Role role = new Role();
        User user = new User();

        role.setName("admin");

        user.setUsername("admin");
        user.setPassword("admin");

        roleRepository.save(role);
        userService.save(user);
    }

}
