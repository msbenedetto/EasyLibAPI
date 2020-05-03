package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.items.Copy;

public interface CopyRepositoryCustom {
    void detach(Copy copy);
}