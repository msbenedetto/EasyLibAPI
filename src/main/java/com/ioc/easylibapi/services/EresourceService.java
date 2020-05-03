package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.items.Eresource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface EresourceService {
    Eresource findById(Long id) throws Exception;

    Page<Eresource> findAll(Specification<Eresource> specs, Pageable pageable);

    Eresource insert(Eresource er);

    Eresource update(Eresource er) throws Exception;

    void deleteById(Long id) throws Exception;
}
