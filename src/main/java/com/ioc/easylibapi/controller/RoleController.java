package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.models.user.Role;
import com.ioc.easylibapi.services.RoleService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class RoleController
 * core class where are declared the methods allowing to extract / insert / update / delete the role information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @GetMapping("{id}")
    public Role byId(@PathVariable("id") Long id) throws Exception {
        return roleService.findById(id);
    }


    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Role.class)})
    @GetMapping
    public Page<Role> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                             @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                             @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                             @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                             @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return roleService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public Role insert(@RequestBody Role role) {
        return roleService.insert(role);
    }

    @PutMapping
    public Role update(@RequestBody Role role) throws Exception {
        return roleService.update(role);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        roleService.deleteById(id);
    }


}
