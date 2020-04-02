package com.ioc.easylibapi.models.booking;

import com.ioc.easylibapi.models.enumerations.BookingStatus;
import com.ioc.easylibapi.models.loan.Loan;
import com.ioc.easylibapi.models.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.List;


/**
 * Class Booking
 * model type of class, describes the Booking object (booking table)
 * We define the link between Loan, User and BookingDetail
 * We set:
 * ManyToOne: 1 user will have many entries (many) in the booking table (to one)
 * Then we relate the booking_id to the different entries it will have in the booking_detail table:
 * OneToMany: 1 loan will have lots of different items detailed in the loan_detail table
 * cascade.ALL, since we want all the operations to be authorized on related entities
 * orphanRemoval = false, we want to keep track of past bookings during a period of time
 */
@Entity
@Table(name = "booking", schema = "public")
public class Booking {
    @Id
    @SequenceGenerator(name = "seq_booking", sequenceName = "seq_booking", allocationSize = 1)
    @GeneratedValue(generator = "seq_booking")
    @Column(name = "booking_id", nullable = false)
    Long id;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "date_booking")
    private Date date_booking;

    @Column(name = "date_collected")
    private Date date_collected;

    @Column(name = "date_limit")
    private Date date_limit;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status")
    private BookingStatus status;

    @OneToMany(
            mappedBy = "booking",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BookingDetail> details;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;


    /**
     * Booking GETTERS AND SETTERS
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_booking() {
        return date_booking;
    }

    public void setDate_booking(Date date_booking) {
        this.date_booking = date_booking;
    }

    public Date getDate_collected() {
        return date_collected;
    }

    public void setDate_collected(Date date_collected) {
        this.date_collected = date_collected;
    }

    public Date getDate_limit() {
        return date_limit;
    }

    public void setDate_limit(Date date_limit) {
        this.date_limit = date_limit;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public List<BookingDetail> getDetails() {
        return details;
    }

    public void setDetails(List<BookingDetail> details) {
        this.details = details;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
