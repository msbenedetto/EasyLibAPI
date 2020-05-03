package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.user.UserStatus;
import com.ioc.easylibapi.repository.UserStatusRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserStatusRepositoryCustomImpl implements UserStatusRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(UserStatus userStatus) {
        entityManager.detach(userStatus);
    }
}