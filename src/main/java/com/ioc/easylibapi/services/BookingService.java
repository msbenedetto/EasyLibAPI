package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.booking.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BookingService {
    Booking findById(Long id) throws Exception;

    Page<Booking> findAll(Specification<Booking> specs, Pageable pageable);

    Booking insert(Booking booking);

    Booking update(Booking booking) throws Exception;

    void deleteById(Long id) throws Exception;
}
