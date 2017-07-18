package com.egniebauer.controllers;

import com.egniebauer.models.Category;
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
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;


    @RequestMapping(value = "admin/category/add", method = RequestMethod.GET)
    public String displayAddCategory(Model model) {
        model.addAttribute("h1", "Add Category");
        model.addAttribute("title", "Kid Friendly STL - Admin");

        model.addAttribute(new Category());
        return "category/add";
    }

    @RequestMapping(value = "admin/category/add", method = RequestMethod.POST)
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
}