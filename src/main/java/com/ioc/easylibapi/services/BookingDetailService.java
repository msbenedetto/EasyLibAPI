package com.ioc.easylibapi.services;

import com.ioc.easylibapi.models.booking.BookingDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BookingDetailService {
    BookingDetail findById(Long id) throws Exception;

    Page<BookingDetail> findAll(Specification<BookingDetail> specs, Pageable pageable);

    BookingDetail insert(BookingDetail bookingDetail);

    BookingDetail update(BookingDetail bookingDetail) throws Exception;

    void deleteById(Long id) throws Exception;
}
