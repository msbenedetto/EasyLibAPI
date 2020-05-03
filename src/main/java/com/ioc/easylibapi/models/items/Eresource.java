package com.ioc.easylibapi.models.items;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class Eresource extends Item{
    @Column(nullable = true)
    private String author;

    /**
     * Eresource GETTERS AND SETTERS
     */

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
