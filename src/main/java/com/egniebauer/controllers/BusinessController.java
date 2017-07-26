package com.egniebauer.controllers;

import com.egniebauer.models.*;
import com.egniebauer.models.data.AgeRangeDao;
import com.egniebauer.models.data.BestTimeDao;
import com.egniebauer.models.data.BusinessDao;
import com.egniebauer.models.data.CategoryDao;
import com.egniebauer.models.forms.BusinessForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elizabeth G Niebauer
 */

@Controller
public class BusinessController {

    @Autowired
    private BusinessDao businessDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private AgeRangeDao ageRangeDao;

    @Autowired
    private BestTimeDao bestTimeDao;

    @RequestMapping("business")
    public String index(Model model) {

        model.addAttribute("h1", "Business Listings");
        model.addAttribute("businesses", businessDao.findAll());
        return "business/index";
    }

    @RequestMapping(value = "admin/business/view/{id}", method = RequestMethod.GET)
    public String displayInformation(Model model, @PathVariable int id) {

        try {

            Business business = businessDao.findOne(id);
            model.addAttribute("h1", business.getName());
            model.addAttribute("business", business);
            return "business/view";

        } catch (IllegalArgumentException e) {

            return "redirect:/admin";
        }
    }

    @RequestMapping(value = "admin/business/add", method = RequestMethod.GET)
    public String displayAdd(Model model) {

        model.addAttribute("h1", "Add Business");
        model.addAttribute("categories", categoryDao.findAll() );
        model.addAttribute("ageRanges", ageRangeDao.findAll() );
        model.addAttribute("bestTimes", bestTimeDao.findAll() );
        model.addAttribute("form", new BusinessForm());
        model.addAttribute("submitText", "Add Business");
        return "business/add-edit";
    }

    @RequestMapping(value = "admin/business/edit/{id}", method = RequestMethod.GET)
    public String displayEdit(Model model, @PathVariable int id) {

        BusinessForm form = new BusinessForm();
        Business editBusiness = businessDao.findOne(id);
        form.prepopulateForm(editBusiness);
        model.addAttribute("categories", categoryDao.findAll() );
        model.addAttribute("ageRanges", ageRangeDao.findAll() );
        model.addAttribute("bestTimes", bestTimeDao.findAll() );
        String h1 = "Edit " + editBusiness.getName();
        model.addAttribute("h1", h1);
        model.addAttribute("form", form);
        model.addAttribute("submitText", "Update");
        return "business/add-edit";
    }


    @RequestMapping(value = "admin/business/add-edit", method = RequestMethod.POST)
    public String processAddEdit(@ModelAttribute @Valid BusinessForm form,
                                     Errors errors, Model model) {

        if (errors.hasErrors()) {
            if (businessDao.exists(form.getBusinessId())) {

                String h1 = "Edit " + form.getBusinessName();
                model.addAttribute("h1", h1);
                model.addAttribute("categories", categoryDao.findAll() );
                model.addAttribute("ageRanges", ageRangeDao.findAll() );
                model.addAttribute("bestTimes", bestTimeDao.findAll() );
                model.addAttribute("submitText", "Update");
                return "business/add-edit";
            }

            model.addAttribute("h1", "Add Business");
            model.addAttribute("form", new BusinessForm());
            model.addAttribute("categories", categoryDao.findAll() );
            model.addAttribute("ageRanges", ageRangeDao.findAll() );
            model.addAttribute("bestTimes", bestTimeDao.findAll() );
            model.addAttribute("submitText", "Add Business");
            return "business/add-edit";
        }

        Business business = new Business( form.getBusinessName() );
        addDetailsFromIds(business, "category", form.getCategoryIds() );
        addDetailsFromIds(business, "ageRange", form.getAgeRangeIds() );
        addDetailsFromIds(business, "bestTimes", form.getBestTimesIds() );

        if (form.getBusinessId() != null) {
            business.setId(form.getBusinessId());
        }
        businessDao.save(business);
        return "redirect:/admin";
    }

    private void addDetailsFromIds(Business newBusiness, String type, Iterable<Integer> ids) {

            switch (type) {

                case "category" :
                    List<Category> categories = new ArrayList<>();
                    for (Integer id : ids) {
                        categories.add(categoryDao.findOne(id));
                    }
                    newBusiness.setCategories(categories);
                    break;

                case "ageRange" :
                    List<AgeRange> ageRanges = new ArrayList<>();
                    for (Integer id : ids) {
                        ageRanges.add(ageRangeDao.findOne(id));
                    }
                    newBusiness.setAgeRanges(ageRanges);
                    break;

                case "bestTimes" :
                    List<BestTime> bestTimes = new ArrayList<>();
                    for (Integer id : ids) {
                        bestTimes.add(bestTimeDao.findOne(id));
                    }
                    newBusiness.setBestTimes(bestTimes);
                    break;
            }
    }

}
