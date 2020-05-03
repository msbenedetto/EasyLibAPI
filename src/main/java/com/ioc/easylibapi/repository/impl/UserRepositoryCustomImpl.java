package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.user.User;
import com.ioc.easylibapi.repository.UserRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(User user) {
        entityManager.detach(user);
    }
}
