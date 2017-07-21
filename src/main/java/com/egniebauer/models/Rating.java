package com.egniebauer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Elizabeth G Niebauer
 */

@Entity
public class Rating {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Max(5)
    private Integer rating;

    @ManyToMany
    private List<Business> businesses;

    public Rating() {
    }

    public Rating(Integer rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

}
