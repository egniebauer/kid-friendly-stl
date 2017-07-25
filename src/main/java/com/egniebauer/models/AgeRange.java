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
public class AgeRange extends BusinessDetail {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=140)
    private String name;

    @NotNull
    @Size(min=3, max=255)
    private String description;

    @ManyToMany(mappedBy = "ageRanges")
    private List<Business> businesses;

    public AgeRange() {
    }

    public AgeRange(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setId(int id) {
        this.id = id;
    }
}
