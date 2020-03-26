package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.UserRole;
import com.ioc.easylibapi.repository.UserRoleRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserRoleRepositoryCustomImpl implements UserRoleRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(UserRole userRole) {
        entityManager.detach(userRole);
    }
}