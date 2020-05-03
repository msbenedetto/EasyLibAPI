package com.ioc.easylibapi.models.items;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ioc.easylibapi.models.booking.BookingDetail;
import com.ioc.easylibapi.models.enumerations.CopyStatus;
import com.ioc.easylibapi.models.library.Library;
import com.ioc.easylibapi.models.loan.LoanDetail;

import javax.persistence.*;
import java.util.List;

/**
 * Class Copy
 * This is our CORE class:
 * This class will concentrate all the items in one place
 * ManyToOne: Copy is linked to the Item class and the Library class by ManyToOne
 * OneToMany: Copy is related to the BookingDetail and LoanDetail classes by OneToMany
 * cascade.ALL, since we want all the operations to be authorized on related entities
 * orphanRemoval = true, because if we delete a user, we want to delete everything that is linked to him/her
 */
@Entity
//@JsonIgnoreProperties("item")
@Table(name="copy", schema="public")
public class Copy {
    @Id
    @SequenceGenerator(name = "seq_copy", sequenceName = "seq_copy", allocationSize = 1)
    @GeneratedValue(generator = "seq_copy")
    @Column(name = "copy_id", nullable = false)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Item.class)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Library.class)
    @JoinColumn(name = "library_id", nullable = false)
    private Library library;

    @Enumerated(EnumType.STRING)
    @Column(name = "copy_status")
    private CopyStatus status;

    @JsonIgnore
    @OneToMany(
            mappedBy = "copy",
            cascade = CascadeType.MERGE,
            orphanRemoval = false
    )
    private List<LoanDetail> loanDetails;

    @JsonIgnore
    @OneToMany(
            mappedBy = "copy",
            cascade = CascadeType.MERGE,
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
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
        this.bookingDetails = bookingDetails;
    }
}