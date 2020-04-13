package com.ioc.easylibapi.models.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ioc.easylibapi.models.enumerations.BookingStatus;
import com.ioc.easylibapi.models.items.Copy;

import javax.persistence.*;


/**
 * Class BookingDetail
 * model type of class, describes the BookingDetail object (booking_detail table)
 * We define the detail of each booking in this class, linking the general booking_id (linked to the user_id) to the central copy table through copy_id
 * We set:
 * ManyToOne: 1 booking_id will have 1 or many entries (many) in the booking_detail table (to one)
 * ManyToOne: 1 copy_id will be 1 or many times in the booking_detail table, since one booking can have 1 or more items in it
 */
@Entity
@Table(name = "booking_detail", schema = "public")
public class BookingDetail {
    @Id
    @SequenceGenerator(name = "seq_booking_detail", sequenceName = "seq_booking_detail", allocationSize = 1)
    @GeneratedValue(generator = "seq_booking_detail")
    @Column(name = "bd_id")
    Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "copy_id", nullable = false)
    private Copy copy;

    @Enumerated(EnumType.STRING)
    @Column(name = "bd_status", nullable = false)
    private BookingStatus status;

    /**
     * BookingDetail GETTERS AND SETTERS
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
