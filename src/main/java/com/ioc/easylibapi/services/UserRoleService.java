package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface UserRoleService {

    UserRole findById(Long id) throws Exception;

    Page<UserRole> findAll(Specification<UserRole> specs, Pageable pageable);

    UserRole insert(UserRole userRole);

    UserRole update(UserRole userRole) throws Exception;

    void deleteById(Long id) throws Exception;
}
