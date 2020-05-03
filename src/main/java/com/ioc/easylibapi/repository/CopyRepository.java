package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.items.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface CopyRepository
 */
@Repository
public interface CopyRepository extends PagingAndSortingRepository<Copy, Long>, JpaSpecificationExecutor<Copy>, JpaRepository<Copy, Long> {
    List<Copy> findByLibraryId(Long id);
}