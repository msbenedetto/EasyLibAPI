package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.models.user.UserStatus;
import com.ioc.easylibapi.services.UserStatusService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class UserStatusController
 * core class where are declared the methods allowing to extract / insert / update / delete the userstatus information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("userstatus")
public class UserStatusController extends BaseController<UserStatus> {

    @Autowired
    private UserStatusService userStatusService;

    @GetMapping("{id}")
    public UserStatus byId(@PathVariable("id") Long id) throws Exception {
        return userStatusService.findById(id);
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = UserStatus.class)})
    @GetMapping
    public Page<UserStatus> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                                 @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                                 @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                                 @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                                 @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return userStatusService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public UserStatus insert(@RequestBody UserStatus userStatus) {
        return userStatusService.insert(userStatus);
    }

    @PutMapping
    public UserStatus update(@RequestBody UserStatus userStatus) throws Exception {
        return userStatusService.update(userStatus);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        userStatusService.deleteById(id);
    }

}
