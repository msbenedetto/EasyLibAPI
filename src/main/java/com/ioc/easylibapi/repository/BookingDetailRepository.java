package com.ioc.easylibapi.repository;

import com.ioc.easylibapi.models.booking.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface BookingDetailRepository
 */
@Repository
public interface BookingDetailRepository extends PagingAndSortingRepository<BookingDetail, Long>, JpaSpecificationExecutor<BookingDetail>, JpaRepository<BookingDetail, Long>, BookingDetailRepositoryCustom {

}