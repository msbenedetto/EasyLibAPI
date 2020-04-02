package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.loan.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface LoanRepository
 */
@Repository
public interface LoanRepository extends PagingAndSortingRepository<Loan, Long>, JpaSpecificationExecutor<Loan>, JpaRepository<Loan, Long>, LoanRepositoryCustom {

}