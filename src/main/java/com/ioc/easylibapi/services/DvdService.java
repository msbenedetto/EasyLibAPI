package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.items.Dvd;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface DvdService {
    Dvd findById(Long id) throws Exception;

    Page<Dvd> findAll(Specification<Dvd> specs, Pageable pageable);

    Dvd insert(Dvd dvd);

    Dvd update(Dvd dvd) throws Exception;

    void deleteById(Long id) throws Exception;
}
