package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.models.items.Eresource;
import com.ioc.easylibapi.services.EresourceService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class EresourceController
 * core class where are declared the methods allowing to extract / insert / update / delete the Eresource information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("eresource")
public class EresourceController extends BaseController<Eresource> {

    @Autowired
    private EresourceService erService;

    @GetMapping("{id}")
    public Eresource byId(@PathVariable("id") Long id) throws Exception {
        return erService.findById(id);
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Eresource.class)})
    @GetMapping
    public Page<Eresource> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                             @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                             @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                             @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                             @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return erService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public Eresource insert(@RequestBody Eresource er) {
        return erService.insert(er);
    }

    @PutMapping
    public Eresource update(@RequestBody Eresource er) throws Exception {
        return erService.update(er);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        erService.deleteById(id);
    }

}
