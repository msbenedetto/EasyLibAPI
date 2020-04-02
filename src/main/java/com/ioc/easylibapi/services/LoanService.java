package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.loan.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface LoanService {
    Loan findById(Long id) throws Exception;

    Page<Loan> findAll(Specification<Loan> specs, Pageable pageable);

    Loan insert(Loan loan);

    Loan update(Loan loan) throws Exception;

    void deleteById(Long id) throws Exception;
}
