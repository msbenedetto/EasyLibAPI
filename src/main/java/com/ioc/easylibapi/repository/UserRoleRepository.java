package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.user.UserRole;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Interface UserRoleRepository
 * defines the method that allows to find the roles associated to an id
 */
public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long>, JpaSpecificationExecutor<UserRole>, UserRoleRepositoryCustom {
    UserRole findById(long id);
}
