package com.pessi.moviesforum.controllers;

import com.pessi.moviesforum.Repository.SectionRepository;
import com.pessi.moviesforum.Repository.ThreadRepository;
import com.pessi.moviesforum.Repository.UserRepository;
import com.pessi.moviesforum.dto.CreateThreadDto;
import com.pessi.moviesforum.entity.Thread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

@Controller
public class CreateThreadController {

    private Logger logger = LoggerFactory.getLogger(CreateThreadController.class);

    @Autowired
    ThreadRepository threadRepository;

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/createThread", method = RequestMethod.GET)
    public String showCreateThread(Model model) {
        logger.debug("/createThread");

        model.addAttribute("createThread", new CreateThreadDto());
        model.addAttribute("sectionList", sectionRepository.findAll());

        return "createThread";
    }

    @RequestMapping(value = "/createThread", method = RequestMethod.POST)
    public String processCreateThread(@ModelAttribute("createThread") CreateThreadDto threadDto) {
        logger.debug("/createThread, " + threadDto);

        Thread thread = new Thread();
        thread.setSection(sectionRepository.findById(threadDto.getSectionId()));
        thread.setTopic(threadDto.getTopic());
        thread.setText(threadDto.getText());
        thread.setCreationDate(LocalDateTime.now());

        User springUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        thread.setAuthor(userRepository.findByUsername(springUser.getUsername()));

        threadRepository.save(thread);

        return "redirect:/home";
    }

}
