package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.models.user.User;
import com.ioc.easylibapi.payload.request.SignupRequest;
import com.ioc.easylibapi.payload.request.UpdateRequest;
import com.ioc.easylibapi.services.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User byId(@PathVariable("id") Long id) throws Exception {
        return userService.findById(id);
    }

    @GetMapping("/email")
    public User byEmail(@RequestParam(value = "user", required = true) String user) throws Exception {
        return userService.findByEmail(user);
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

    //test implementation : HOW TO SEARCH a particular user (list matches)
    @RequestMapping(method = RequestMethod.GET, value = "/usersearch")
    @ResponseBody
    public List<User> searchTwo(@RequestParam(value = "q", required = false) String search,
                                @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                                @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                                @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                                @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {
        return userService.searchUser(buildSpecification2(search), pageRequest(page, size, sort, field));
    }


    //test Baeldung
  /*  @RequestMapping(method = RequestMethod.GET, value = "/users")
    @ResponseBody
    public List<User> search(@RequestParam(value = "search", required = false) String search) {

        List<SearchCriteria> params = new ArrayList<>();
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
        return userService.searchUser(params);
    }*/
    //test Baeldung


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

    /*ORIGINAL
    @PutMapping
    public User update(@RequestBody User user) throws Exception {
        return userService.update(user);
    }*/

    //NEW
    @PutMapping
    public User update(@Valid @RequestBody UpdateRequest updateRequest) throws Exception {
        User user = new User(
                updateRequest.getUsername(),
                updateRequest.getEmail(),
                updateRequest.getFirstname(),
                updateRequest.getLastname(),
                updateRequest.getCellphone(),
                updateRequest.getAddress(),
                updateRequest.getZipcode(),
                updateRequest.getCity(),
                updateRequest.getCountry(),
                updateRequest.getRole()
        );
        return userService.insert(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        userService.deleteById(id);
    }

}
