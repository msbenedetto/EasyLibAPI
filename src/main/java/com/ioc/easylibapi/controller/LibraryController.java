package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.models.library.Library;
import com.ioc.easylibapi.services.LibraryService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class LibraryController
 * core class where are declared the methods allowing to extract / insert / update / delete the library information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("library")
public class LibraryController extends BaseController<Library> {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("{id}")
    public Library byId(@PathVariable("id") Long id) throws Exception {
        return libraryService.findById(id);
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Library.class)})
    @GetMapping
    public Page<Library> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                             @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                             @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                             @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                             @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return libraryService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public Library insert(@RequestBody Library library) {
        return libraryService.insert(library);
    }

    @PutMapping
    public Library update(@RequestBody Library library) throws Exception {
        return libraryService.update(library);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        libraryService.deleteById(id);
    }

}
