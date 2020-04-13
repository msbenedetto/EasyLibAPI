package com.ioc.easylibapi.models.user;

import com.ioc.easylibapi.models.enumerations.USEnum;
import com.ioc.easylibapi.models.loan.Loan;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


/**
 * Class UserStatus
 * model type of class, describes the UserStatus relationship
 * We need to control when a user has overdue the loan, so here we drop the loan id where the date is overdue by user (we push the user_id too) and we apply a penalty.
 * The user will be locked during 7 days if the due date is overpass
 */
@Entity
@Table(name = "user_status", schema = "public")
public class UserStatus {


    @Id
    @SequenceGenerator(name = "seq_us", sequenceName = "seq_us", allocationSize = 1)
    @GeneratedValue(generator = "seq_us")
    @Column(name = "us_id")
    Long id;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotEmpty
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id")
    private Loan fkLoan;

    @NotEmpty
    @Column(name = "date_begin_penalty")
    private Date date_begin_penalty;

    @Column(name = "date_end_penalty")
    private Date date_end_penalty;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private USEnum status;


    /**
     * UserStatus GETTERS AND SETTERS
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

    public Loan getFkLoan() {
        return fkLoan;
    }

    public void setFkLoan(Loan fkLoan) {
        this.fkLoan = fkLoan;
    }

    public Date getDate_begin_penalty() {
        return date_begin_penalty;
    }

    public void setDate_begin_penalty(Date date_begin_penalty) {
        this.date_begin_penalty = date_begin_penalty;
    }

    public Date getDate_end_penalty() {
        return date_end_penalty;
    }

    public void setDate_end_penalty(Date date_end_penalty) {
        this.date_end_penalty = date_end_penalty;
    }

    public USEnum getStatus() {
        return status;
    }

    public void setStatus(USEnum status) {
        this.status = status;
    }
}
