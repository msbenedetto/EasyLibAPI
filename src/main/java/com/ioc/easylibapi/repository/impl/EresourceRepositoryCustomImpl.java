package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.items.Eresource;
import com.ioc.easylibapi.repository.EresourceRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EresourceRepositoryCustomImpl implements EresourceRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(Eresource er) {
        entityManager.detach(er);
    }
}
