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

    @ManyToMany(mappedBy = "businesses")
    private List<AgeRange> ageRanges;

    @ManyToMany(mappedBy = "businesses")
    private List<BestTime> bestTimes;

    @ManyToMany(mappedBy = "businesses")
    private List<Category> categories;

    @ManyToMany(mappedBy = "businesses")
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
}
