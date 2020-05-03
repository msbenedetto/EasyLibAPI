package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.items.Copy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CopyService {
    Copy findById(Long id) throws Exception;

    Page<Copy> findAll(Specification<Copy> specs, Pageable pageable);

    Copy insert(Copy copy);

    Copy update(Copy copy) throws Exception;

    void deleteById(Long id) throws Exception;

    List<Copy> findByLibrary(Long libraryId);
}
