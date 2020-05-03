package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.items.Item;
import com.ioc.easylibapi.repository.ItemRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(Item item) {
        entityManager.detach(item);
    }
}
