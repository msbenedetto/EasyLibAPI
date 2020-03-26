package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.User;

public interface UserRepositoryCustom {
    void detach(User user);
}