package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.items.Copy;
import com.ioc.easylibapi.repository.CopyRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CopyRepositoryCustomImpl implements CopyRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(Copy copy) {
        entityManager.detach(copy);
    }
}
