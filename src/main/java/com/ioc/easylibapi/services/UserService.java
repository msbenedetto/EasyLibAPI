package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface UserService {
    User findById(Long id) throws Exception;

    Page<User> findAll(Specification<User> specs, Pageable pageable);

    User insert(User user);

    User update(User user) throws Exception;

    void deleteById(Long id) throws Exception;
}
