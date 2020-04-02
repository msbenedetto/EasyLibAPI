package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.booking.BookingDetail;
import com.ioc.easylibapi.repository.BookingDetailRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BookingDetailRepositoryCustomImpl implements BookingDetailRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(BookingDetail bookingDetail) {
        entityManager.detach(bookingDetail);
    }
}
