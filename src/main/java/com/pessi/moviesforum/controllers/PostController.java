package com.pessi.moviesforum.controllers;

import com.pessi.moviesforum.Repository.PostRepository;
import com.pessi.moviesforum.Repository.ThreadPostRepository;
import com.pessi.moviesforum.Repository.ThreadRepository;
import com.pessi.moviesforum.Repository.UserRepository;
import com.pessi.moviesforum.dto.AddPostDto;
import com.pessi.moviesforum.entity.Post;
import com.pessi.moviesforum.entity.ThreadPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

@Controller
public class PostController {

    private Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    ThreadRepository threadRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ThreadPostRepository threadPostRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/addPost/{threadId}", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("addPost") AddPostDto postDto, @PathVariable(value = "threadId") int threadId) {
        logger.debug("/addPost");

        User springUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Post post = new Post();
        post.setText(postDto.getText());
        post.setCreationDate(LocalDateTime.now());
        post.setAuthor(userRepository.findByUsername(springUser.getUsername()));

        ThreadPost threadPost = new ThreadPost();
        threadPost.setThread(threadRepository.findById(threadId));
        threadPost.setPost(post);

        threadPostRepository.save(threadPost);

        return "redirect:/thread/" + threadId;
    }

}
