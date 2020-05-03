package com.ioc.easylibapi.models.items;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Book extends Item{

    @Column (nullable = true)
    private  String author;

    @Column(nullable = true)
    private String ISBN;

    /**
     * Book GETTERS AND SETTERS
     */
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
