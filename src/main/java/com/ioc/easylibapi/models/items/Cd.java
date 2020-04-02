package com.ioc.easylibapi.models.items;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * Class Cd
 * model type of class, describes the Cd object (cd table)
 * We relate the cd_id to the copy table:
 * OneToMany: 1 cd_id can be present many times in the Copy table (same cd in different libraries, duplicates cds in the same library to extend the offer, etc)
 * cascade.ALL, since we want all the operations to be authorized on related entities
 * orphanRemoval = true, thus specifying that orphaned entities should be removed
 */
@Entity
@Table(name = "cd", schema = "public")
public class Cd {
    @Id
    @SequenceGenerator(name = "seq_cd", sequenceName = "seq_cd", allocationSize = 1)
    @GeneratedValue(generator = "seq_cd")
    @Column(name = "cd_id", nullable = false)
    Long id;

    @NotEmpty
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "composer", nullable = true)
    private String composer;

    @Column(name = "performer", nullable = true)
    private String performer;

    @Column(name = "director", nullable = true)
    private String director;

    @Column(name = "publisher", nullable = true)
    private String publisher;

    @Column(name = "date_edit", nullable = true)
    private Date date_edit;

    @Column(name = "type", nullable = true)
    private String type;

    @OneToMany(
            mappedBy = "cd",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Copy> copy;


    /**
     * Cd GETTERS AND SETTERS
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

    public List<Copy> getCdCopies() {
        return copy;
    }

    public void setCdCopies(List<Copy> cdCopies) {
        this.copy = cdCopies;
    }
}
