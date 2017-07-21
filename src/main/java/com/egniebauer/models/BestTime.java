package com.egniebauer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Elizabeth G Niebauer
 */

@Entity
public class BestTime {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @ManyToMany
    private List<Business> businesses;

    public BestTime() {
    }

    public BestTime(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setName(String name) {
        this.name = name;
    }

}
