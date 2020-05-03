package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.booking.BookingDetail;

public interface BookingDetailRepositoryCustom {
    void detach(BookingDetail bookingDetail);
}
