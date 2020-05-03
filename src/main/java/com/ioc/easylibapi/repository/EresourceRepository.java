package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.items.Eresource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface EresourceRepository
 */
@Repository
public interface EresourceRepository extends PagingAndSortingRepository<Eresource, Long>, JpaSpecificationExecutor<Eresource>, JpaRepository<Eresource, Long> {
}