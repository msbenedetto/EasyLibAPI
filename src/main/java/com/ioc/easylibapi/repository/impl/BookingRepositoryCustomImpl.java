package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.booking.Booking;
import com.ioc.easylibapi.repository.BookingRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BookingRepositoryCustomImpl implements BookingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(Booking booking) {
        entityManager.detach(booking);
    }
}
