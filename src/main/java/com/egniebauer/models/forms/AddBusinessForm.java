package com.egniebauer.models.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Elizabeth G Niebauer
 */
public class AddBusinessForm {

    @NotNull
    @Size(min=3, max=140)
    private String businessName;

    @NotNull
    private List<Integer> categoryIds;

    @NotNull
    private List<Integer> ageRangeIds;

    @NotNull
    private List<Integer> bestTimesIds;

    public AddBusinessForm() {
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

    public List<Integer> getAgeRangeIds() {
        return ageRangeIds;
    }

    public void setAgeRangeIds(List<Integer> ageRangeIds) {
        this.ageRangeIds = ageRangeIds;
    }

    public List<Integer> getBestTimesIds() {
        return bestTimesIds;
    }

    public void setBestTimesIds(List<Integer> bestTimesIds) {
        this.bestTimesIds = bestTimesIds;
    }
}
