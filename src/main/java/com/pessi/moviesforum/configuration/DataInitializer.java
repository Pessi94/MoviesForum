package com.pessi.moviesforum.configuration;

import com.pessi.moviesforum.Repository.RoleRepository;
import com.pessi.moviesforum.Repository.SectionRepository;
import com.pessi.moviesforum.Repository.ThreadRepository;
import com.pessi.moviesforum.entity.Role;
import com.pessi.moviesforum.entity.Section;
import com.pessi.moviesforum.entity.Thread;
import com.pessi.moviesforum.entity.User;
import com.pessi.moviesforum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
public class DataInitializer {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    ThreadRepository threadRepository;


    @PostConstruct
    private void initialize() {
        Role role = new Role();
        User user = new User();

        role.setName("admin");

        user.setUsername("admin");
        user.setPassword("admin");

        roleRepository.save(role);
        userService.save(user);


        Section section1 = new Section();
        Section section2 = new Section();

        section1.setName("Filmy");
        section2.setName("Seriale");

        sectionRepository.save(section1);
        sectionRepository.save(section2);


        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        Thread thread3 = new Thread();

        thread1.setTopic("Leon zawodowiec");
        thread2.setTopic("Przyjaciele");
        thread3.setTopic("Avengers: Endgame");
        thread1.setText("No ale się szczelali co nie?");
        thread2.setText("Fajny serial");
        thread3.setText("Polecam");
        thread1.setAuthor(user);
        thread2.setAuthor(user);
        thread3.setAuthor(user);
        thread1.setCreationDate(LocalDateTime.of(2017, 6, 14, 13, 24, 15));
        thread2.setCreationDate(LocalDateTime.of(2018, 9, 20, 16, 52, 11));
        thread3.setCreationDate(LocalDateTime.of(2018, 5, 25, 14, 6, 56));
        thread1.setSection(section1);
        thread2.setSection(section2);
        thread3.setSection(section1);

        threadRepository.save(thread1);
        threadRepository.save(thread2);
        threadRepository.save(thread3);
    }

}
