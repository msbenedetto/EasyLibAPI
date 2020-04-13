package com.ioc.easylibapi.models.items;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(
            mappedBy = "item",
            cascade = CascadeType.MERGE,
            orphanRemoval = false
    )
    private List<Copy> copies;




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
