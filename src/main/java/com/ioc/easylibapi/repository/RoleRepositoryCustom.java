package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.user.Role;

public interface RoleRepositoryCustom {
    void detach(Role role);
}