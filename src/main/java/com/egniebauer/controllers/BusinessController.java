package com.egniebauer.controllers;

import com.egniebauer.models.*;
import com.egniebauer.models.data.AgeRangeDao;
import com.egniebauer.models.data.BestTimeDao;
import com.egniebauer.models.data.BusinessDao;
import com.egniebauer.models.data.CategoryDao;
import com.egniebauer.models.forms.AddBusinessForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "admin/business/add", method = RequestMethod.GET)
    public String displayAddBusiness(Model model) {

        model.addAttribute("h1", "Add Business");
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("ageRanges", ageRangeDao.findAll());
        model.addAttribute("bestTimes", bestTimeDao.findAll());

        model.addAttribute("form", new AddBusinessForm());
        return "business/add";
    }

    @RequestMapping(value = "admin/business/add", method = RequestMethod.POST)
    public String processAddBusiness(@ModelAttribute @Valid AddBusinessForm form,
                                     Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("h1", "Add Business");
            model.addAttribute("categories", categoryDao.findAll());
            model.addAttribute("ageRanges", ageRangeDao.findAll());
            model.addAttribute("bestTimes", bestTimeDao.findAll());

            model.addAttribute("form", new AddBusinessForm());
            return "business/add";
        }

        Business newBusiness = new Business( form.getBusinessName() );

        addDetailsFromIds(newBusiness, "category", form.getCategoryIds() );
        addDetailsFromIds(newBusiness, "ageRange", form.getAgeRangeIds() );
        addDetailsFromIds(newBusiness, "bestTimes", form.getBestTimesIds() );

        businessDao.save(newBusiness);
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
