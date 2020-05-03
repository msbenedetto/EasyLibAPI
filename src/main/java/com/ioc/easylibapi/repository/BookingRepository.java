package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface BookingRepository
 */
@Repository
public interface BookingRepository extends PagingAndSortingRepository<Booking, Long>, JpaSpecificationExecutor<Booking>, JpaRepository<Booking, Long>, BookingRepositoryCustom {
    List<Booking> findByUserId(Long userId);

}