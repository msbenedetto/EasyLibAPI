package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.items.Dvd;
import com.ioc.easylibapi.repository.DvdRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DvdRepositoryCustomImpl implements DvdRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(Dvd dvd) {
        entityManager.detach(dvd);
    }
}
