package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.library.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface LibraryService {
    Library findById(Long id) throws Exception;

    Page<Library> findAll(Specification<Library> specs, Pageable pageable);

    Library insert(Library library);

    Library update(Library library) throws Exception;

    void deleteById(Long id) throws Exception;
}
