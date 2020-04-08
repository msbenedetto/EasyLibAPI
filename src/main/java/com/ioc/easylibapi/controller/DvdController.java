package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.models.items.Dvd;
import com.ioc.easylibapi.services.DvdService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class DvdController
 * core class where are declared the methods allowing to extract / insert / update / delete the dvd information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("dvd")
public class DvdController extends BaseController<Dvd> {

    @Autowired
    private DvdService dvdService;

    @GetMapping("{id}")
    public Dvd byId(@PathVariable("id") Long id) throws Exception {
        return dvdService.findById(id);
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Dvd.class)})
    @GetMapping
    public Page<Dvd> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                             @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                             @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                             @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                             @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return dvdService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public Dvd insert(@RequestBody Dvd dvd) {
        return dvdService.insert(dvd);
    }

    @PutMapping
    public Dvd update(@RequestBody Dvd dvd) throws Exception {
        return dvdService.update(dvd);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        dvdService.deleteById(id);
    }

}
