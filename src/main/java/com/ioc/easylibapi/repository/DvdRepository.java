package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.items.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface DvdRepository
 */
@Repository
public interface DvdRepository extends PagingAndSortingRepository<Dvd, Long>, JpaSpecificationExecutor<Dvd>, JpaRepository<Dvd, Long> {
}