package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.models.items.Magazine;
import com.ioc.easylibapi.services.MagazineService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class MagazineController
 * core class where are declared the methods allowing to extract / insert / update / delete the magazine information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("magazine")
public class MagazineController extends BaseController<Magazine> {

    @Autowired
    private MagazineService magazineService;

    @GetMapping("{id}")
    public Magazine byId(@PathVariable("id") Long id) throws Exception {
        return magazineService.findById(id);
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Magazine.class)})
    @GetMapping
    public Page<Magazine> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                             @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                             @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                             @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                             @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return magazineService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public Magazine insert(@RequestBody Magazine magazine) {
        return magazineService.insert(magazine);
    }

    @PutMapping
    public Magazine update(@RequestBody Magazine magazine) throws Exception {
        return magazineService.update(magazine);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        magazineService.deleteById(id);
    }

}
