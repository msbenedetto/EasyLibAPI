package com.ioc.easylibapi.models.items;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * Class Dvd
 * model type of class, describes the Dvd object (dvd table)
 * We relate the dvd_id to the copy table:
 * OneToMany: 1 dvd_id can be present many times in the Copy table (same dvd in different libraries, duplicates dvds in the same library to extend the offer, etc)
 * cascade.ALL, since we want all the operations to be authorized on related entities
 * orphanRemoval = true, thus specifying that orphaned entities should be removed
 */
@Entity
@Table(name = "dvd", schema = "public")
public class Dvd {
    @Id
    @SequenceGenerator(name = "seq_dvd", sequenceName = "seq_dvd", allocationSize = 1)
    @GeneratedValue(generator = "seq_dvd")
    @Column(name = "dvd_id", nullable = false)
    Long id;

    @NotEmpty
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "main_actor", nullable = true)
    private String main_actor;

    @Column(name = "director", nullable = true)
    private String director;

    @Column(name = "publisher", nullable = true)
    private String publisher;

    @Column(name = "date_edit", nullable = true)
    private Date date_edit;

    @Column(name = "type", nullable = true)
    private String type;

    @OneToMany(
            mappedBy = "dvd",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Copy> copy;


    /**
     * Dvd GETTERS AND SETTERS
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

    public String getMain_actor() {
        return main_actor;
    }

    public void setMain_actor(String main_actor) {
        this.main_actor = main_actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
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

    public List<Copy> getCopy() {
        return copy;
    }

    public void setCopy(List<Copy> copy) {
        this.copy = copy;
    }
}
