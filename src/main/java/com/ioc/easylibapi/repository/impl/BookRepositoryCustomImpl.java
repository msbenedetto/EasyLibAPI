package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.items.Book;
import com.ioc.easylibapi.repository.BookRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BookRepositoryCustomImpl implements BookRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(Book book) {
        entityManager.detach(book);
    }
}
