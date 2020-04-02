package com.ioc.easylibapi.models.items;

import com.ioc.easylibapi.models.booking.BookingDetail;
import com.ioc.easylibapi.models.library.Library;
import com.ioc.easylibapi.models.loan.LoanDetail;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Class Copy
 * This is our CORE class:
 * This class will concentrate all the items in one place but only through foreign keys.
 * The copies can be so far of 4 types: book, magazine, cd and dvd (so 4 tables). It could be easy to add other tables and then just add a foreign key to this table and then adapt the API.
 * The copies are also associated through this class to a library.
 * We define the link between Copy, Library and the other type of items, such as Book, Magazines etc
 * We set:
 * ManyToOne: 1 library will have many entries (many) in the copy table (to one)
 * Then we relate the different items ids to the copy table, as followd:
 * ManyToOne: one book may be represented many times (many) in the copy table (to one)
 * >> the same relationship is set up as many times as type of items we may have (in this case: Book, Magazine, Cd and Dvd)
 * In this class, we could ADD foreign keys to the newly created tables that we would need to add,
 * for example we could consider another table concerning newspapers, or internet resources, or comic books, or a specific art books table, etc...
 * Again we try to reach escalability in a flexible data model
 */
@Entity
@Table(name = "copy", schema = "public")
public class Copy {
    @Id
    @SequenceGenerator(name = "seq_copy", sequenceName = "seq_copy", allocationSize = 1)
    @GeneratedValue(generator = "seq_copy")
    @Column(name = "copy_id", nullable = false)
    Long id;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id", nullable = false)
    private Library library;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "magazine_id", nullable = false)
    private Magazine magazine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_id", nullable = false)
    private Cd cd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dvd_id", nullable = false)
    private Dvd dvd;

    @Enumerated(EnumType.STRING)
    @Column(name = "copy_status")
    private CopyStatus status;

    @OneToMany(
            mappedBy = "copy",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<LoanDetail> loanDetails;

    @OneToMany(
            mappedBy = "copy",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<BookingDetail> bookingDetails;




    /**
     * Copy GETTERS AND SETTERS
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Library getFkLibrary() {
        return library;
    }

    public void setFkLibrary(Library fkLibrary) {
        this.library = fkLibrary;
    }


    public CopyStatus getStatus() {
        return status;
    }

    public void setStatus(CopyStatus status) {
        this.status = status;
    }

    public List<LoanDetail> getLoanDetails() {
        return loanDetails;
    }

    public void setLoanDetails(List<LoanDetail> loanDetails) {
        this.loanDetails = loanDetails;
    }

    public List<BookingDetail> getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(List<BookingDetail> bookingDetails) {
        bookingDetails = bookingDetails;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Cd getCd() {
        return cd;
    }

    public void setCd(Cd cd) {
        this.cd = cd;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }
}