package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.loan.Loan;
import com.ioc.easylibapi.repository.LoanRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class LoanRepositoryCustomImpl implements LoanRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(Loan loan) {
        entityManager.detach(loan);
    }
}
