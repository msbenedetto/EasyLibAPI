package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.models.UserRole;
import com.ioc.easylibapi.services.UserRoleService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
/**
 * Class UserRoleController
 * core class where are declared the methods allowing to extract / insert / update / delete the userrole information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("userrole")
public class UserRoleController extends BaseController<UserRole> {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("{id}")
    public UserRole byId(@PathVariable("id") Long id) throws Exception {
        return userRoleService.findById(id);
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = UserRole.class)})
    @GetMapping
    public Page<UserRole> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                                 @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                                 @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                                 @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                                 @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return userRoleService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public UserRole insert(@RequestBody UserRole userRole) {
        return userRoleService.insert(userRole);
    }

    @PutMapping
    public UserRole update(@RequestBody UserRole userRole) throws Exception {
        return userRoleService.update(userRole);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        userRoleService.deleteById(id);
    }

}
