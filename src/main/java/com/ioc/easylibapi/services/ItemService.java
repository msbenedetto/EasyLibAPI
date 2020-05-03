package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.items.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ItemService {
    Item findById(Long id) throws Exception;

    Page<Item> findAll(Specification<Item> specs, Pageable pageable);

    Item insert(Item item);

    Item update(Item item) throws Exception;

    void deleteById(Long id) throws Exception;
}
