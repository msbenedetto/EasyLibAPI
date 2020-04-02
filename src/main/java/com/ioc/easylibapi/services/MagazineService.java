package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.items.Magazine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface MagazineService {
    Magazine findById(Long id) throws Exception;

    Page<Magazine> findAll(Specification<Magazine> specs, Pageable pageable);

    Magazine insert(Magazine magazine);

    Magazine update(Magazine magazine) throws Exception;

    void deleteById(Long id) throws Exception;
}
