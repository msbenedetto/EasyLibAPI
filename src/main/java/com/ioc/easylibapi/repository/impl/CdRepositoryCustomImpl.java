package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.items.Cd;
import com.ioc.easylibapi.repository.CdRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CdRepositoryCustomImpl implements CdRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(Cd cd) {
        entityManager.detach(cd);
    }
}
