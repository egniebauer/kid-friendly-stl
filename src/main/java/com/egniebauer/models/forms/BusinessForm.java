package com.egniebauer.models.forms;

import com.egniebauer.models.AgeRange;
import com.egniebauer.models.BestTime;
import com.egniebauer.models.Business;
import com.egniebauer.models.Category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elizabeth G Niebauer
 */
public class BusinessForm {

    @NotNull
    @Size(min=3, max=140)
    private String businessName;

    @NotNull
    private List<Integer> categoryIds;

    @NotNull
    private List<Integer> ageRangeIds;

    @NotNull
    private List<Integer> bestTimesIds;

    private Integer businessId;

    public BusinessForm() {
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public void addCategoryIds(List<Category> categories) {
        List<Integer> ids = new ArrayList<>();

        for (Category cat : categories) {
            ids.add(cat.getId());
        }

        setCategoryIds(ids);
    }

    public List<Integer> getAgeRangeIds() {
        return ageRangeIds;
    }

    public void setAgeRangeIds(List<Integer> ageRangeIds) {
        this.ageRangeIds = ageRangeIds;
    }

    public void addAgeRangeIds(List<AgeRange> ageRanges) {
        List<Integer> ids = new ArrayList<>();

        for (AgeRange range : ageRanges) {
            ids.add(range.getId());
        }

        setAgeRangeIds(ids);
    }

    public List<Integer> getBestTimesIds() {
        return bestTimesIds;
    }

    public void setBestTimesIds(List<Integer> bestTimesIds) {
        this.bestTimesIds = bestTimesIds;
    }

    public void addBestTimesIds(List<BestTime> bestTimes) {
        List<Integer> ids = new ArrayList<>();

        for (BestTime time : bestTimes) {
            ids.add(time.getId());
        }

        setBestTimesIds(ids);
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public void prepopulateForm(Business editBusiness) {
        setBusinessName(editBusiness.getName());
        addCategoryIds(editBusiness.getCategories());
        addAgeRangeIds(editBusiness.getAgeRanges());
        addBestTimesIds(editBusiness.getBestTimes());
        setBusinessId(editBusiness.getId());
    }
}
