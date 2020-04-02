package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.loan.LoanDetail;
import com.ioc.easylibapi.repository.LoanDetailRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class LoanDetailRepositoryCustomImpl implements LoanDetailRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(LoanDetail loanDetail) {
        entityManager.detach(loanDetail);
    }
}
