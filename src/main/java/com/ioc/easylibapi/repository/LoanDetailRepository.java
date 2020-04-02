package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.loan.LoanDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface LoanDetailRepository
 */
@Repository
public interface LoanDetailRepository extends PagingAndSortingRepository<LoanDetail, Long>, JpaSpecificationExecutor<LoanDetail>, JpaRepository<LoanDetail, Long>, LoanDetailRepositoryCustom {

}