package com.ioc.easylibapi.models.items;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * Class Item
 * A core class in this model, as we allow to flexibly add new classes of other kind of possible articles
 * Item has a serie of common attributes between the different kind of articles.
 * All other object classes: book, cd, dvd, eresource and magazine are EXTENDING Item
 * Item is meant to be a description of the article
 * OneToMany relation with class Copy, that contains instances in the physical world of the description done in Item
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="item", discriminatorType = DiscriminatorType.INTEGER)
public class Item {
    @Id
    @SequenceGenerator(name = "seq_item", sequenceName = "seq_item", allocationSize = 1)
    @GeneratedValue(generator = "seq_item")
    @Column(name = "item_id", nullable = false)
    Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String publisher;

    @Column(nullable = true)
    private Date date_edit;

    @Column(nullable = true)
    private String type;

    @Column(nullable = true)
    private String language;

    //@JsonIgnore
    @JsonManagedReference(value="item")
    @OneToMany(
            mappedBy = "item",
            cascade = CascadeType.MERGE,
            orphanRemoval = false
    )
    private List<Copy> copies;

    /**
     * Item GETTERS AND SETTERS
     */


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getDate_edit() {
        return date_edit;
    }

    public void setDate_edit(Date date_edit) {
        this.date_edit = date_edit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }
}
