package com.egniebauer.controllers;

import com.egniebauer.models.BestTime;
import com.egniebauer.models.data.BestTimeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Elizabeth G Niebauer
 */

@Controller
@RequestMapping(value = "admin/time")
public class BestTimeController {

    @Autowired
    private BestTimeDao bestTimeDao;

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String displayInformation(Model model, @PathVariable int id) {

        try {

            BestTime bestTime = bestTimeDao.findOne(id);
            model.addAttribute("h1", bestTime.getName());
            model.addAttribute("bestTime", bestTime);
            return "bestTime/view";

        } catch (IllegalArgumentException e) {

            return "redirect:/admin";
        }
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAdd(Model model) {

        model.addAttribute("h1", "Add Time");
        model.addAttribute(new BestTime());
        model.addAttribute("submitText", "Add");
        return "bestTime/add";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String displayEdit(Model model, @PathVariable int id) {

        try {

            BestTime bestTime = bestTimeDao.findOne(id);
            String h1 = "Edit " + bestTime.getName();
            model.addAttribute("h1", h1);
            model.addAttribute("category", bestTime);
            model.addAttribute("submitText", "Update");
            return "bestTime/add-edit";

        } catch (IllegalArgumentException e) {

            return "redirect:/admin";
        }
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTime(@ModelAttribute @Valid BestTime newTime,
                                 Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("h1", "Add Time");
            model.addAttribute("title", "Kid Friendly STL - Admin");
            return "bestTime/add";
        }
        bestTimeDao.save(newTime);
        return "redirect:/admin";
    }
}
