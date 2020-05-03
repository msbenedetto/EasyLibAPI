package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.user.UserStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface UserStatusService {
    UserStatus findById(Long id) throws Exception;

    Page<UserStatus> findAll(Specification<UserStatus> specs, Pageable pageable);

    UserStatus insert(UserStatus userStatus);

    UserStatus update(UserStatus userStatus) throws Exception;

    void deleteById(Long id) throws Exception;
}
