package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.models.items.Cd;
import com.ioc.easylibapi.services.CdService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class CdController
 * core class where are declared the methods allowing to extract / insert / update / delete the cd information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("cd")
public class CdController extends BaseController<Cd> {

    @Autowired
    private CdService cdService;

    @GetMapping("{id}")
    public Cd byId(@PathVariable("id") Long id) throws Exception {
        return cdService.findById(id);
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Cd.class)})
    @GetMapping
    public Page<Cd> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                             @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                             @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                             @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                             @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return cdService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public Cd insert(@RequestBody Cd cd) {
        return cdService.insert(cd);
    }

    @PutMapping
    public Cd update(@RequestBody Cd cd) throws Exception {
        return cdService.update(cd);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        cdService.deleteById(id);
    }

}
