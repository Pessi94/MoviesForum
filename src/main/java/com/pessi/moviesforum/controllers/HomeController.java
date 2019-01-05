package com.pessi.moviesforum.controllers;

import com.pessi.moviesforum.Repository.SectionRepository;
import com.pessi.moviesforum.services.MoviesRankingWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    SectionRepository sectionRepository;

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectHome() {
        return "redirect:home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome(Model model) {
        logger.debug("/home");
        model.addAttribute("movieRankingList", new MoviesRankingWorker().getSliderMovieData());
        model.addAttribute("movieRankingListJSON", new MoviesRankingWorker().getSliderMovieDataJSON());
        model.addAttribute("sectionList", sectionRepository.findAll());

        return "home";
    }

}
