package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.models.User;
import com.ioc.easylibapi.payload.request.SignupRequest;
import com.ioc.easylibapi.services.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Class UserController
 * core class where are declared the methods allowing to extract / insert / update / delete the user information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("{id}")
    public User byId(@PathVariable("id") Long id) throws Exception {
        return userService.findById(id);
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = User.class)})
    @GetMapping
    public Page<User> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                             @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                             @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                             @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                             @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return userService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public User insert(@Valid @RequestBody SignupRequest signUpRequest) {
        User user = new User(
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()),
                signUpRequest.getFirstname(),
                signUpRequest.getLastname(),
                signUpRequest.getCellphone(),
                signUpRequest.getAddress(),
                signUpRequest.getZipcode(),
                signUpRequest.getCity(),
                signUpRequest.getCountry(),
                signUpRequest.getRole()
        );
        return userService.insert(user);
    }

    @PutMapping
    public User update(@RequestBody User user) throws Exception {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        userService.deleteById(id);
    }

}
