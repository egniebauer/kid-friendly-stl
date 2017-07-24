package com.egniebauer.controllers;

import com.egniebauer.models.Category;
import com.egniebauer.models.data.CategoryDao;
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
@RequestMapping(value = "admin/category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String displayCategory(Model model, @PathVariable int id) {

        try {

            Category category = categoryDao.findOne(id);
            model.addAttribute("h1", category.getName());
            model.addAttribute("category", category);
            return "category/view";

        } catch (IllegalArgumentException e) {

            return "redirect:/admin";
        }
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCategory(Model model) {

        model.addAttribute("h1", "Add Category");
        model.addAttribute(new Category());
        model.addAttribute("submitText", "Add");
        return "category/add-edit";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String displayEditCategory(Model model, @PathVariable int id) {

        try {

            Category category = categoryDao.findOne(id);
            String h1 = "Edit " + category.getName();
            model.addAttribute("h1", h1);
            model.addAttribute("category", category);
            model.addAttribute("submitText", "Update");
            return "category/add-edit";

        } catch (IllegalArgumentException e) {

            return "redirect:/admin";
        }
    }

    @RequestMapping(value = "add-edit", method = RequestMethod.POST)
    public String processEditCategory(@ModelAttribute @Valid Category category,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {

            if (categoryDao.exists(category.getId())) {

                String h1 = "Edit " + category.getName();
                model.addAttribute("h1", h1);
                model.addAttribute("submitText", "Update");
                return "category/add-edit";
            }

            model.addAttribute("h1", "Add Category");
            model.addAttribute(new Category());
            model.addAttribute("submitText", "Add");
            return "category/add-edit";
        }

        categoryDao.save(category);
        return "redirect:/admin";
    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String displayRemoveCategory(Model model, @PathVariable int id) {

        try {

            Category category = categoryDao.findOne(id);
            String h1 = "Remove " + category.getName();
            model.addAttribute("h1", h1);
            model.addAttribute("category", category);
            model.addAttribute("submitText", "DELETE");
            return "category/remove";

        } catch (IllegalArgumentException e) {

            return "redirect:/admin";
        }
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCategory(@ModelAttribute @Valid Category category,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {

            String h1 = "Remove " + category.getName();
            model.addAttribute("h1", h1);
            model.addAttribute("submitText", "DELETE");
            return "category/remove";
        }

        categoryDao.delete(category);
        return "redirect:/admin";
    }

}