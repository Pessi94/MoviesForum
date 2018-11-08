package com.pessi.moviesforum.controllers;

import com.pessi.moviesforum.services.MoviesRankingWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/")
    public String redirectHome() {
        return "redirect:home";
    }

    @RequestMapping(value = "/home")
    public String showHome(Model model) {
        logger.info("homeController");
        model.addAttribute("movieRankingList", new MoviesRankingWorker().getSliderMovieData());
        model.addAttribute("movieRankingListJSON", new MoviesRankingWorker().getSliderMovieDataJSON());
        return "home";
    }

}
