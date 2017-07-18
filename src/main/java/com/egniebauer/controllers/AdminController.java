package com.egniebauer.controllers;

import com.egniebauer.models.data.AgeRangeDao;
import com.egniebauer.models.data.BestTimeDao;
import com.egniebauer.models.data.BusinessDao;
import com.egniebauer.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Elizabeth G Niebauer
 */

@Controller
public class AdminController {

    @Autowired private CategoryDao categoryDao;
    @Autowired private AgeRangeDao ageRangeDao;
    @Autowired private BestTimeDao bestTimeDao;
    @Autowired private BusinessDao businessDao;


    @RequestMapping("admin")
    public String index(Model model) {

        model.addAttribute("businesses", businessDao.findAll());
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("ageRanges", ageRangeDao.findAll());
        model.addAttribute("bestTimes", bestTimeDao.findAll());

        model.addAttribute("title", "Kid Friendly STL - Admin");

        return "admin/index";
    }

}
