package com.ioc.easylibapi.controller;


import com.ioc.easylibapi.models.booking.BookingDetail;
import com.ioc.easylibapi.services.BookingDetailService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class BookingDetailController
 * core class where are declared the methods allowing to extract / insert / update / delete the booking detail information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("bkgdetail")
public class BookingDetailController extends BaseController {

    @Autowired
    private BookingDetailService bookingDetailService;

    @GetMapping("{id}")
    public BookingDetail byId(@PathVariable("id") Long id) throws Exception {
        return bookingDetailService.findById(id);
    }


    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = BookingDetail.class)})
    @GetMapping
    public Page<BookingDetail> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                                @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                                @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                                @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                                @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return bookingDetailService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public BookingDetail insert(@RequestBody BookingDetail bookingDetail) {
        return bookingDetailService.insert(bookingDetail);
    }

    @PutMapping
    public BookingDetail update(@RequestBody BookingDetail bookingDetail) throws Exception {
        return bookingDetailService.update(bookingDetail);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        bookingDetailService.deleteById(id);
    }


}
