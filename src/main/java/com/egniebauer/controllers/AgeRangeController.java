package com.egniebauer.controllers;

import com.egniebauer.models.AgeRange;
import com.egniebauer.models.data.AgeRangeDao;
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
@RequestMapping(value = "admin/age-range")
public class AgeRangeController {

    @Autowired
    private AgeRangeDao ageRangeDao;

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String displayAgeRange(Model model, @PathVariable int id) {

        try {

            AgeRange ageRange = ageRangeDao.findOne(id);
            model.addAttribute("h1", ageRange.getName());
            model.addAttribute("ageRange", ageRange);
            return "ageRange/view";

        } catch (IllegalArgumentException e) {

            return "redirect:/admin";
        }
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAdd(Model model) {

        model.addAttribute("h1", "Add Age Range");
        model.addAttribute("ageRange", new AgeRange());
        model.addAttribute("submitText", "Add");
        return "ageRange/add-edit";
    }


    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String displayEdit(Model model, @PathVariable int id) {

        try {

            AgeRange ageRange = ageRangeDao.findOne(id);
            String h1 = "Edit " + ageRange.getName();
            model.addAttribute("h1", h1);
            model.addAttribute("ageRange", ageRange);
            model.addAttribute("submitText", "Update");
            return "ageRange/add-edit";

        } catch (IllegalArgumentException e) {

            return "redirect:/admin";
        }
    }

    @RequestMapping(value = "add-edit", method = RequestMethod.POST)
    public String processAddEdit(@ModelAttribute @Valid AgeRange ageRange,
                                 Errors errors, Model model) {

        if (errors.hasErrors()) {

            if (ageRangeDao.exists(ageRange.getId())) {

                String h1 = "Edit " + ageRange.getName();
                model.addAttribute("h1", h1);
                model.addAttribute("submitText", "Update");
                return "ageRange/add-edit";
            }

            model.addAttribute("h1", "Add Age Range");
            model.addAttribute("ageRange", new AgeRange());
            model.addAttribute("submitText", "Add");
            return "ageRange/add-edit";
        }

        ageRangeDao.save(ageRange);
        return "redirect:/admin";
    }


    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String displayRemove(Model model, @PathVariable int id) {

        try {

            AgeRange ageRange = ageRangeDao.findOne(id);
            String h1 = "Remove " + ageRange.getName();
            model.addAttribute("h1", h1);
            model.addAttribute("ageRange", ageRange);
            model.addAttribute("submitText", "DELETE");
            return "ageRange/remove";

        } catch (IllegalArgumentException e) {

            return "redirect:/admin";
        }
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemove(@ModelAttribute @Valid AgeRange ageRange,
                                Errors errors, Model model) {

        if (errors.hasErrors()) {

            String h1 = "Remove " + ageRange.getName();
            model.addAttribute("h1", h1);
            model.addAttribute("submitText", "DELETE");
            return "ageRange/remove";
        }

        ageRangeDao.delete(ageRange);
        return "redirect:/admin";
    }

}