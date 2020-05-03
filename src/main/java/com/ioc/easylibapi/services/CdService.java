package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.items.Cd;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface CdService {
    Cd findById(Long id) throws Exception;

    //Cd findByTitle(String title) throws Exception;

    Page<Cd> findAll(Specification<Cd> specs, Pageable pageable);

    Cd insert(Cd cd);

    Cd update(Cd cd) throws Exception;

    void deleteById(Long id) throws Exception;
}
