package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.booking.Booking;
import com.ioc.easylibapi.models.booking.BookingCreation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface BookingService {
    Booking findById(Long id) throws Exception;

    Page<Booking> findAll(Specification<Booking> specs, Pageable pageable);

    Booking insert(Booking booking);

    Booking insertBooking(BookingCreation booking);

    Booking update(Booking booking) throws Exception;

    void deleteById(Long id) throws Exception;
    List<Booking> findByUser(Long user_id);
}
