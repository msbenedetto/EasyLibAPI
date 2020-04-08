package com.ioc.easylibapi.models.items;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("5")
public class Dvd extends Item {

    @Column(nullable = true)
    private String director;

    @Column(nullable = true)
    private String main_actor;

    /**
     * Dvd GETTERS AND SETTERS
     */
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMain_actor() {
        return main_actor;
    }

    public void setMain_actor(String main_actor) {
        this.main_actor = main_actor;
    }
}
