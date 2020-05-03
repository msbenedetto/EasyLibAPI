package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.models.items.Copy;
import com.ioc.easylibapi.services.CopyService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class CopyController
 * core class where are declared the methods allowing to extract / insert / update / delete the copy information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("copy")
public class CopyController extends BaseController<Copy> {

    @Autowired
    private CopyService copyService;

    @GetMapping("{id}")
    public Copy byId(@PathVariable("id") Long id) throws Exception {
        return copyService.findById(id);
    }

    @GetMapping("library/{id}")
    public List<Copy> byLibraryId(@PathVariable("id") Long id) throws Exception {
        return copyService.findByLibrary(id);
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Copy.class)})
    @GetMapping
    public Page<Copy> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                             @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                             @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                             @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                             @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return copyService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public Copy insert(@RequestBody Copy copy) {
        return copyService.insert(copy);
    }

    @PutMapping
    public Copy update(@RequestBody Copy copy) throws Exception {
        return copyService.update(copy);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        copyService.deleteById(id);
    }

}
