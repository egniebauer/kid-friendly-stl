package com.egniebauer.controllers;

import com.egniebauer.models.AgeRange;
import com.egniebauer.models.data.AgeRangeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Elizabeth G Niebauer
 */

@Controller
public class AgeRangeController {

    @Autowired
    private AgeRangeDao ageRangeDao;


    @RequestMapping(value = "admin/age-range/add", method = RequestMethod.GET)
    public String displayAddAgeRange(Model model) {
        model.addAttribute("h1", "Add Age Range");
        model.addAttribute("title", "Kid Friendly STL - Admin");

        model.addAttribute(new AgeRange());
        return "ageRange/add";
    }

    @RequestMapping(value = "admin/age-range/add", method = RequestMethod.POST)
    public String processAddAgeRange(@ModelAttribute @Valid AgeRange newAgeRange,
                                     Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("h1", "Add Age Range");
            model.addAttribute("title", "Kid Friendly STL - Admin");
            return "ageRange/add";
        }
        ageRangeDao.save(newAgeRange);
        return "redirect:/admin";
    }
}