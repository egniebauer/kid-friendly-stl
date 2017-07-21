package com.egniebauer.controllers;

import com.egniebauer.models.AgeRange;
import com.egniebauer.models.BestTime;
import com.egniebauer.models.Business;
import com.egniebauer.models.Category;
import com.egniebauer.models.data.AgeRangeDao;
import com.egniebauer.models.data.BestTimeDao;
import com.egniebauer.models.data.BusinessDao;
import com.egniebauer.models.data.CategoryDao;
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
@RequestMapping("admin")
public class AdminController {

    @Autowired private CategoryDao categoryDao;
    @Autowired private AgeRangeDao ageRangeDao;
    @Autowired private BestTimeDao bestTimeDao;
    @Autowired private BusinessDao businessDao;

    // Request path: /admin
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("ageRanges", ageRangeDao.findAll());
        model.addAttribute("bestTimes", bestTimeDao.findAll());
        model.addAttribute("title", "Kid Friendly STL - Admin");

        return "admin/index";
    }

    @RequestMapping(value = "category/add", method = RequestMethod.GET)
    public String displayAddCategory(Model model) {
        model.addAttribute("h1", "Add Category");
        model.addAttribute("title", "Kid Friendly STL - Admin");

        model.addAttribute(new Category());
        return "category/add";
    }

    @RequestMapping(value = "category/add", method = RequestMethod.POST)
    public String processAddCategory(@ModelAttribute @Valid Category newCategory,
                                     Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("h1", "Add Category");
            model.addAttribute("title", "Kid Friendly STL - Admin");
            return "category/add";
        }
        categoryDao.save(newCategory);
        return "redirect:/admin";
    }

    @RequestMapping(value = "age-range/add", method = RequestMethod.GET)
    public String displayAddAgeRange(Model model) {
        model.addAttribute("h1", "Add Age Range");
        model.addAttribute("title", "Kid Friendly STL - Admin");

        model.addAttribute(new AgeRange());
        return "ageRange/add";
    }

    @RequestMapping(value = "age-range/add", method = RequestMethod.POST)
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

    @RequestMapping(value = "times/add", method = RequestMethod.GET)
    public String displayAddTime(Model model) {
        model.addAttribute("h1", "Add Time");
        model.addAttribute("title", "Kid Friendly STL - Admin");

        model.addAttribute(new BestTime());
        return "bestTime/add";
    }

    @RequestMapping(value = "times/add", method = RequestMethod.POST)
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

    @RequestMapping(value = "business/add", method = RequestMethod.GET)
    public String displayAddBusiness(Model model) {
        model.addAttribute("h1", "Add Business");
        model.addAttribute("title", "Kid Friendly STL - Admin");
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("ageRanges", ageRangeDao.findAll());
        model.addAttribute("bestTimes", bestTimeDao.findAll());

        model.addAttribute(new Business());
        return "business/add";
    }

    @RequestMapping(value = "business/add", method = RequestMethod.POST)
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
