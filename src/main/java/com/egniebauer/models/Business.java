package com.egniebauer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


/**
 * Created by Elizabeth G Niebauer
 */

@Entity
public class Business {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=140)
    private String name;

    @ManyToMany
    private List<AgeRange> ageRanges;

    @ManyToMany
    private List<BestTime> bestTimes;

    @ManyToMany
    private List<Category> categories;

    @ManyToMany
    private List<Rating> ratings;


    public Business(String name) {
        this.name = name;
    }

    public Business() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AgeRange> getAgeRanges() {
        return ageRanges;
    }

    public List<BestTime> getBestTimes() {
        return bestTimes;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void addAgeRange(AgeRange ageRange) {
        ageRanges.add(ageRange);
    }

    public void addBestTime(BestTime bestTime) {
        bestTimes.add(bestTime);
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public void setAgeRanges(List<AgeRange> ageRanges) {
        this.ageRanges = ageRanges;
    }

    public void setBestTimes(List<BestTime> bestTimes) {
        this.bestTimes = bestTimes;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
