package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.loan.LoanDetail;

public interface LoanDetailRepositoryCustom {
    void detach(LoanDetail loanDetail);
}
