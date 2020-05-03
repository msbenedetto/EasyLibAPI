package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.items.Magazine;

public interface MagazineRepositoryCustom {
    void detach(Magazine magazine);
}