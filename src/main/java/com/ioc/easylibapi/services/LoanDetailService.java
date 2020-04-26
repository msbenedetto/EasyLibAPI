package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.loan.LoanDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface LoanDetailService {
    LoanDetail findById(Long id) throws Exception;

    Page<LoanDetail> findAll(Specification<LoanDetail> specs, Pageable pageable);

    LoanDetail insert(LoanDetail loanDetail);

    LoanDetail update(LoanDetail loanDetail) throws Exception;

    LoanDetail returnDetail(LoanDetail loanDetail) throws Exception;

    void deleteById(Long id) throws Exception;
}
