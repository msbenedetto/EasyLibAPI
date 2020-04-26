package com.ioc.easylibapi.models.booking;

import java.util.List;

public class BookingCreation {

    private Booking booking;
    private List<BookingDetail> details;

    public BookingCreation(Booking booking, List<BookingDetail> details) {
        this.booking = booking;
        this.details = details;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public List<BookingDetail> getDetails() {
        return details;
    }

    public void setDetails(List<BookingDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "BookingCreation{" +
                "booking=" + booking +
                ", details=" + details +
                '}';
    }
}
