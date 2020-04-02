package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.items.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BookService {
    Book findById(Long id) throws Exception;

    Page<Book> findAll(Specification<Book> specs, Pageable pageable);

    Book insert(Book book);

    Book update(Book book) throws Exception;

    void deleteById(Long id) throws Exception;
}
