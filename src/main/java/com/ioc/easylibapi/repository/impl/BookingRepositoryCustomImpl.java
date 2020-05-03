package com.ioc.easylibapi.repository.impl;

import com.ioc.easylibapi.models.booking.Booking;
import com.ioc.easylibapi.repository.BookingRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BookingRepositoryCustomImpl implements BookingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detach(Booking booking) {
        entityManager.detach(booking);
    }

    @Override
    public List<Booking> getByUser(Long userId) {
        return null;
    }


}
