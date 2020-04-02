package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.library.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface LibraryRepository
 */
@Repository
public interface LibraryRepository extends PagingAndSortingRepository<Library, Long>, JpaSpecificationExecutor<Library>, JpaRepository<Library, Long> {
}