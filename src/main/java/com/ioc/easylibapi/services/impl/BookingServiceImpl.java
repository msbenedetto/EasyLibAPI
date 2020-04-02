package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.booking.Booking;
import com.ioc.easylibapi.repository.BookingRepository;
import com.ioc.easylibapi.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public Booking findById(Long id) throws Exception {
        Optional<Booking> optional = bookingRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The Booking with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<Booking> findAll(Specification<Booking> specs, Pageable pageable) {
        return bookingRepository.findAll(specs, pageable);
    }

    @Override
    public Booking insert(Booking booking) {
        Booking createdEntity = bookingRepository.save(booking);
        return createdEntity;
    }

    @Override
    public Booking update(Booking booking) throws Exception {
        if (booking == null || booking.getId() == null || booking.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<Booking> currentEntity = bookingRepository.findById(booking.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The Booking with ID: " + booking.getId() + "couldn't be found.");
        }
        Booking updatedEntity = bookingRepository.save(booking);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Booking> entityToDelete = bookingRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The Booking with ID: " + id + "couldn't be found.");
        }
        bookingRepository.deleteById(id);
    }

}
