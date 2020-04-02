package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.booking.Booking;

public interface BookingRepositoryCustom {
    void detach(Booking booking);
}
