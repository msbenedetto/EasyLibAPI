package com.ioc.easylibapi.models.loan;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ioc.easylibapi.models.booking.Booking;
import com.ioc.easylibapi.models.enumerations.LoanStatus;
import com.ioc.easylibapi.models.user.User;
import com.ioc.easylibapi.models.user.UserStatus;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * Class Loan
 * model type of class, describes the Loan object (loan table)
 * We define the link between Loan, User, UserStatus and LoanDetail and we set:
 * User <-> Loan
 * ManyToOne: 1 user will have many entries (many) in the loan table (to one)
 * Then we relate the loan_id to the different entries it will have in the loan_detail table:
 * OneToMany: 1 loan will have lots of different items detailed in the loan_detail table
 * cascade.ALL, since we want all the operations to be authorized on related entities
 * orphanRemoval = false, we want to keep track of past loans during a period of time
 */
@Entity
@Table(name = "loan", schema = "public")
public class Loan {
    @Id
    @SequenceGenerator(name = "seq_loan", sequenceName = "seq_loan", allocationSize = 1)
    @GeneratedValue(generator = "seq_loan")
    @Column(name = "loan_id", nullable = false)
    Long id;

    /**
     * booking_id : attribute links to the booking table
     * This attribute can be empty, as a user can make a booking and then transform it in a loan OR directly go to the library an make the loan
     */
    @JsonBackReference(value="userloan")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "date_begin_loan", nullable = false)
    private Date date_begin_loan;

    @Column(name = "date_scheduled_return", nullable = false)
    private Date date_scheduled_return;

    @Column(name = "date_returned", nullable = true)
    private Date date_returned;

    @Enumerated(EnumType.STRING)
    @Column(name = "loan_status", nullable = false)
    private LoanStatus status;

    @JsonManagedReference(value="loan")
    @OneToMany(
            mappedBy = "loan",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<LoanDetail> loanDetails;

    // We may have OR NOT a previous booking to build the loan
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = true)
    private Booking bookingOrigin;

    // We may have OR NOT a penalty on a loan (if we return the loan too late)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "us_id", nullable = true)
    private UserStatus userStatus;

    /**
     * Loan GETTERS AND SETTERS
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate_begin_loan() {
        return date_begin_loan;
    }

    public void setDate_begin_loan(Date date_begin_loan) {
        this.date_begin_loan = date_begin_loan;
    }

    public Date getDate_scheduled_return() {
        return date_scheduled_return;
    }

    public void setDate_scheduled_return(Date date_scheduled_return) {
        this.date_scheduled_return = date_scheduled_return;
    }

    public Date getDate_returned() {
        return date_returned;
    }

    public void setDate_returned(Date date_returned) {
        this.date_returned = date_returned;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public List<LoanDetail> getDetails() {
        return loanDetails;
    }

    public void setDetails(List<LoanDetail> details) {
        this.loanDetails = details;
    }

    public Booking getBooking() {
        return bookingOrigin;
    }

    public void setBooking(Booking booking) {
        this.bookingOrigin = booking;
    }

    public List<LoanDetail> getLoanDetails() {
        return loanDetails;
    }

    public void setLoanDetails(List<LoanDetail> loanDetails) {
        this.loanDetails = loanDetails;
    }

    public Booking getBookingOrigin() {
        return bookingOrigin;
    }

    public void setBookingOrigin(Booking bookingOrigin) {
        this.bookingOrigin = bookingOrigin;
    }

}
