package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.booking.Booking;

import java.util.List;

public interface BookingRepositoryCustom {
    void detach(Booking booking);
    public List<Booking> getByUser(Long userId);
}
