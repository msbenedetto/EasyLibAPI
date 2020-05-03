package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.booking.BookingDetail;
import com.ioc.easylibapi.repository.BookingDetailRepository;
import com.ioc.easylibapi.services.BookingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("bookingDetailService")
public class BookingDetailServiceImpl implements BookingDetailService {

    @Autowired
    private BookingDetailRepository bookingDetailRepository;


    @Override
    public BookingDetail findById(Long id) throws Exception {
        Optional<BookingDetail> optional = bookingDetailRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The BookingDetail with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<BookingDetail> findAll(Specification<BookingDetail> specs, Pageable pageable) {
        return bookingDetailRepository.findAll(specs, pageable);
    }

    @Override
    public BookingDetail insert(BookingDetail bookingDetail) {
        BookingDetail createdEntity = bookingDetailRepository.save(bookingDetail);
        return createdEntity;
    }

    @Override
    public BookingDetail update(BookingDetail bookingDetail) throws Exception {
        if (bookingDetail == null || bookingDetail.getId() == null || bookingDetail.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<BookingDetail> currentEntity = bookingDetailRepository.findById(bookingDetail.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The BookingDetail with ID: " + bookingDetail.getId() + "couldn't be found.");
        }
        BookingDetail updatedEntity = bookingDetailRepository.save(bookingDetail);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<BookingDetail> entityToDelete = bookingDetailRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The BookingDetail with ID: " + id + "couldn't be found.");
        }
        bookingDetailRepository.deleteById(id);
    }

}
