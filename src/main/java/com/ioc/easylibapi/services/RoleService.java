package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface RoleService {
    Role findById(Long id) throws Exception;

    Page<Role> findAll(Specification<Role> specs, Pageable pageable);

    Role insert(Role role);

    Role update(Role role) throws Exception;

    void deleteById(Long id) throws Exception;
}
