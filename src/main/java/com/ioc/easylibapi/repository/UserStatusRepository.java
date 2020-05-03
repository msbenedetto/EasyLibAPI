package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.user.UserStatus;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Interface UserStatusRepository
 * defines the method that allows to find the status associated to a user id
 */
public interface UserStatusRepository extends PagingAndSortingRepository<UserStatus, Long>, JpaSpecificationExecutor<UserStatus>, UserStatusRepositoryCustom {
    UserStatus findById(long id);
}
