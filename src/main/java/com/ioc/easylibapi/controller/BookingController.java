package com.ioc.easylibapi.controller;


import com.ioc.easylibapi.models.booking.Booking;
import com.ioc.easylibapi.models.booking.BookingCreation;
import com.ioc.easylibapi.services.BookingService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class BookingController
 * core class where are declared the methods allowing to extract / insert / update / delete the booking information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("booking")
public class BookingController extends BaseController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("{id}")
    public Booking byId(@PathVariable("id") Long id) throws Exception {
        return bookingService.findById(id);
    }


    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Booking.class)})
    @GetMapping
    public Page<Booking> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                             @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                             @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                             @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                             @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return bookingService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public Booking insert(@RequestBody Booking booking) {
        return bookingService.insert(booking);
    }

    @PostMapping("/object")
    public Booking insertBooking(@RequestBody BookingCreation booking) {
        return bookingService.insertBooking(booking);
    }

    @PutMapping
    public Booking update(@RequestBody Booking booking) throws Exception {
        return bookingService.update(booking);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        bookingService.deleteById(id);
    }


}
