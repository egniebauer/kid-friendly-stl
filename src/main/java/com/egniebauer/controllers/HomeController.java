package com.egniebauer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Elizabeth G Niebauer
 */

@Controller
@RequestMapping("")
public class HomeController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Kid Friendly STL");

        return "index";
    }


}
