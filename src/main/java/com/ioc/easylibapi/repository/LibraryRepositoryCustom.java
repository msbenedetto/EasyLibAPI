package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.library.Library;

public interface LibraryRepositoryCustom {
    void detach(Library library);
}