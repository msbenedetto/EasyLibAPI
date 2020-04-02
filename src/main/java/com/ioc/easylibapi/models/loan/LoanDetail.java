package com.ioc.easylibapi.models.loan;

import com.ioc.easylibapi.models.items.Copy;
import com.ioc.easylibapi.models.enumerations.LoanStatus;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;


/**
 * Class LoanDetail
 * model type of class, describes the LoanDetail object (loan_detail table)
 * We define the detail of each loan in this class, linking the general loan_id (linked to the user_id) to the central copy table through copy_id
 * We set:
 * ManyToOne: 1 loan_id will have 1 or many entries (many) in the loan_detail table (to one)
 * ManyToOne: 1 copy_id will be 1 or many times in the loan_detail table, since one loan can have 1 or more items in it
 */
@Entity
@Table(name = "loan_detail", schema = "public")
public class LoanDetail {
    @Id
    @SequenceGenerator(name = "seq_loan_detail", sequenceName = "seq_loan_detail", allocationSize = 1)
    @GeneratedValue(generator = "seq_loan_detail")
    @Column(name = "ld_id")
    Long id;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "copy_id", nullable = false)
    private Copy copy;

    @Column(name = "date_returned", nullable = true)
    private Date date_returned;

    @Enumerated(EnumType.STRING)
    @Column(name = "ld_status")
    private LoanStatus status;


    /**
     * LoanDetail GETTERS AND SETTERS
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Loan getFkLoan() {
        return loan;
    }

    public void setFkLoan(Loan fkLoan) {
        this.loan = fkLoan;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
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
}
