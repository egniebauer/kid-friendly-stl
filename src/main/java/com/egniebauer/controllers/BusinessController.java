package com.egniebauer.controllers;

import com.egniebauer.models.Business;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Elizabeth G Niebauer
 */
public class BusinessController extends AdminController {

    @RequestMapping(value = "admin/business/add", method = RequestMethod.GET)
    public String displayAddBusiness(Model model) {
        model.addAttribute("h1", "Add Business");
        model.addAttribute("title", "Kid Friendly STL - Admin");
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("ageRanges", ageRangeDao.findAll());
        model.addAttribute("bestTimes", bestTimeDao.findAll());

        model.addAttribute(new Business());
        return "business/add";
    }

    @RequestMapping(value = "admin/business/add", method = RequestMethod.POST)
    public String processAddBusiness(@ModelAttribute @Valid Business newBusiness,
                                     Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("h1", "Add Business");
            model.addAttribute("title", "Kid Friendly STL - Admin");
            model.addAttribute("categories", categoryDao.findAll());
            model.addAttribute("ageRanges", ageRangeDao.findAll());
            model.addAttribute("bestTimes", bestTimeDao.findAll());

            return "business/add";
        }
        businessDao.save(newBusiness);
        return "redirect:/admin";
    }
}
