package com.ioc.easylibapi.models.items;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * Class Magazine
 * model type of class, describes the Magazine object (magazine table)
 * We relate the mag_id to the copy table:
 * OneToMany: 1 mag_id can be present many times in the Copy table (same magazine in different libraries, duplicates magazines in the same library to extend the offer, etc)
 * cascade.ALL, since we want all the operations to be authorized on related entities
 * orphanRemoval = true, thus specifying that orphaned entities should be removed
 */
@Entity
@Table(name = "magazine", schema = "public")
public class Magazine {
    @Id
    @SequenceGenerator(name = "seq_mag", sequenceName = "seq_mag", allocationSize = 1)
    @GeneratedValue(generator = "seq_mag")
    @Column(name = "mag_id", nullable = false)
    Long id;

    @NotEmpty
    @Column(name = "title", nullable = false)
    private String title;

    @NotEmpty
    @Column(name = "number", nullable = true)
    private long number;

    @Column(name = "publisher", nullable = true)
    private String publisher;

    @Column(name = "date_edit", nullable = true)
    private Date date_edit;

    @Column(name = "type", nullable = true)
    private String type;


    @OneToMany(
            mappedBy = "magazine",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Copy> copy;


    /**
     * Magazine GETTERS AND SETTERS
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

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
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
