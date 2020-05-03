package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.user.Role;
import com.ioc.easylibapi.repository.RoleRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RoleRepositoryCustomImpl implements RoleRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(Role role) {
        entityManager.detach(role);
    }
}
