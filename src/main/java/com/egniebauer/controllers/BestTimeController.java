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
        model.addAttribute("bestTime", new BestTime());
        model.addAttribute("submitText", "Add");
        return "bestTime/add-edit";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String displayEdit(Model model, @PathVariable int id) {

        try {

            BestTime bestTime = bestTimeDao.findOne(id);
            String h1 = "Edit " + bestTime.getName();
            model.addAttribute("h1", h1);
            model.addAttribute("bestTime", bestTime);
            model.addAttribute("submitText", "Update");
            return "bestTime/add-edit";

        } catch (IllegalArgumentException e) {

            return "redirect:/admin";
        }
    }

    @RequestMapping(value = "add-edit", method = RequestMethod.POST)
    public String processAddEdit(@ModelAttribute @Valid BestTime bestTime,
                                 Errors errors, Model model) {

        if (errors.hasErrors()) {

            if (bestTimeDao.exists(bestTime.getId())) {

                String h1 = "Edit " + bestTime.getName();
                model.addAttribute("h1", h1);
                model.addAttribute("submitText", "Update");
                return "bestTime/add-edit";
            }

            model.addAttribute("h1", "Add Time");
            model.addAttribute("bestTime", new BestTime());
            model.addAttribute("submitText", "Add");
            return "bestTime/add-edit";
        }

        bestTimeDao.save(bestTime);
        return "redirect:/admin";
    }

}
