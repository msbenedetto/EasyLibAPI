package com.ioc.easylibapi.controller.utils;

import org.springframework.data.jpa.domain.Specification;

public class SpecBuilder<T> {

    private Specification<T> specification;

    public void addSpecification(
            String key,
            String operation,
            Object value) {

        Specification<T> addedSpecification = new ApplicationSpec<>(new SearchCriteria(key, operation, value));

            specification = Specification.where(specification).and(addedSpecification);
    }

    public Specification<T> getSpecification() {
        return specification;
    }
}

