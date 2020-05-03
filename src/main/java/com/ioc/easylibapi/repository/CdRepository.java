package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.items.Cd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface CdRepository
 */
@Repository
public interface CdRepository extends PagingAndSortingRepository<Cd, Long>, JpaSpecificationExecutor<Cd>, JpaRepository<Cd, Long> {
}