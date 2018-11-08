package com.pessi.moviesforum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @RequestMapping(value = "/search")
    public String search(Model model, @RequestParam(value = "searchText") String searchText) {
        model.addAttribute("text", searchText);
        return "searchResult";
    }

}
