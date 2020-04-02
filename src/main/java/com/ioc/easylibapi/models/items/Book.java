package com.ioc.easylibapi.models.items;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;


/**
 * Class Book
 * model type of class, describes the Book object (book table)
 * We relate the book_id to the copy table:
 * OneToMany: 1 book_id can be present many times in the Copy table
 * cascade.ALL, since we want all the operations to be authorized on related entities
 * orphanRemoval = true, thus specifying that orphaned entities should be removed
 */
@Entity
@Table(name = "book", schema = "public")
public class Book {
    @Id
    @SequenceGenerator(name = "seq_book", sequenceName = "seq_book", allocationSize = 1)
    @GeneratedValue(generator = "seq_book")
    @Column(name = "book_id", nullable = false)
    Long id;

    @NotEmpty
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = true)
    private String author;

    @Column(name = "publisher", nullable = true)
    private String publisher;

    @Column(name = "date_edit", nullable = true)
    private Date date_edit;

    @Column(name = "type", nullable = true)
    private String type;

    @Column(name = "language", nullable = true)
    private String language;

    @NotEmpty
    @Column(name = "ISBN", nullable = true)
    private String ISBN;

    @OneToMany(
            mappedBy = "book",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Copy> copy;


    /**
     * Book GETTERS AND SETTERS
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public List<Copy> getCopy() {
        return copy;
    }

    public void setCopy(List<Copy> copy) {
        this.copy = copy;
    }
}
