package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.items.Magazine;
import com.ioc.easylibapi.repository.MagazineRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MagazineRepositoryCustomImpl implements MagazineRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(Magazine magazine) {
        entityManager.detach(magazine);
    }
}
