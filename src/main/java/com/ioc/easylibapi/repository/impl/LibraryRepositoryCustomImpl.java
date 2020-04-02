package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.library.Library;
import com.ioc.easylibapi.repository.LibraryRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class LibraryRepositoryCustomImpl implements LibraryRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(Library library) {
        entityManager.detach(library);
    }
}
