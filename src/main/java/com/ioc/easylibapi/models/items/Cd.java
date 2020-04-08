package com.ioc.easylibapi.models.items;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("4")
public class Cd extends Item{
    @Column(nullable = true)
    private String composer;
    @Column(nullable = true)
    private String performer;
    @Column(nullable = true)
    private String director;

    /**
     * Cd GETTERS AND SETTERS
     */
    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
