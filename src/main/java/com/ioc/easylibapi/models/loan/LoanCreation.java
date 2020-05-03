package com.ioc.easylibapi.models.loan;

import java.util.List;

public class LoanCreation {

    private Loan loan;
    private List<LoanDetail> details;

    public LoanCreation(Loan loan, List<LoanDetail> details) {
        this.loan = loan;
        this.details = details;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public List<LoanDetail> getDetails() {
        return details;
    }

    public void setDetails(List<LoanDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "LoanCreation{" +
                "loan=" + loan +
                ", details=" + details +
                '}';
    }
}
