package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.loan.Loan;

public interface LoanRepositoryCustom {
    void detach(Loan loan);
}
