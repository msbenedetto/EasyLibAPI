package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.items.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface ItemRepository
 */
@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long>, JpaSpecificationExecutor<Item>, JpaRepository<Item, Long> {
}