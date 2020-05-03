package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.items.Item;

public interface ItemRepositoryCustom {
    void detach(Item item);
}