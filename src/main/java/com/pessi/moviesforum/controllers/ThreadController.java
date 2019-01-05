package com.pessi.moviesforum.controllers;

import com.pessi.moviesforum.Repository.ThreadRepository;
import com.pessi.moviesforum.dto.AddPostDto;
import com.pessi.moviesforum.entity.Thread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThreadController {

    private Logger logger = LoggerFactory.getLogger(ThreadController.class);

    @Autowired
    ThreadRepository threadRepository;

    @RequestMapping(value = "/thread/{threadId}")
    public String showThread(@PathVariable(value = "threadId") int threadId, Model model) {
        logger.debug("/thread");

        Thread thread = threadRepository.findById(threadId);

        model.addAttribute("thread", thread);
        model.addAttribute("addPost", new AddPostDto());

        return "thread";
    }

    @RequestMapping(value = "/thread/delete/{threadId}")
    public String deleteThread(@PathVariable(value = "threadId") int threadId) {
        logger.debug("deleteThread -> /home");

        threadRepository.deleteById(threadId);

        return "redirect:/home";
    }

}
