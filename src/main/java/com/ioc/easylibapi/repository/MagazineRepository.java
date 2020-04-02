package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.items.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface MagazineRepository
 */
@Repository
public interface MagazineRepository extends PagingAndSortingRepository<Magazine, Long>, JpaSpecificationExecutor<Magazine>, JpaRepository<Magazine, Long> {
}