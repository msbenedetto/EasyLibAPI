package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.items.Book;

public interface BookRepositoryCustom {
    void detach(Book book);
}