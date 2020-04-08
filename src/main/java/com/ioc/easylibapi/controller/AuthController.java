package com.ioc.easylibapi.controller;
/**
 * @author Eric Rubio, Hassan Zerouali, Mathilde Benedetto
 * copyright 2020
 */

import com.ioc.easylibapi.models.user.Role;
import com.ioc.easylibapi.models.user.User;
import com.ioc.easylibapi.payload.request.SignupRequest;
import com.ioc.easylibapi.payload.response.MessageResponse;
import com.ioc.easylibapi.repository.RoleRepository;
import com.ioc.easylibapi.repository.UserRepository;
import com.ioc.easylibapi.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

/**
 * Class AuthController
 * core class where are declared the methods allowing the user to register, login and logout
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager manager;
    @Autowired
    JwtTokenProvider provider;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    private EntityManager entityManager;

    /**
     * User Login
     * method login()
     * Allows users to login to the main page.
     * The user has to provide his username and the password to access the resource
     * The method is also retrieving the type of role (admin or simple user)
     *
     * @param  @RequestBody User : the User entity, stored in models   an absolute URL giving the base location of the image
     * @return 2 possibilities:
     * 1. an ok message with the TOKEN of the session
     * 2. a ko message in case the credentials are incorrect
     */
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        try {
            String username = user.getUsername();
            manager.authenticate(new UsernamePasswordAuthenticationToken(username, user.getPassword()));
            List<String> roles = this.userRepository.findByUsername(username).getRoles().stream().map(role -> role.getRoleName()).collect(Collectors.toList());
            String token = provider.createToken(username, roles);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            return ResponseEntity.ok(new MessageResponse("Invalid username / password supplied!"));
        }
    }

    /**
     * User Registration
     * method register()
     * Allows users to create a profile that will be stored in the database.
     * The user has to provide mandatory information such as: username, password, email and cellphone
     * The other bits of information (firstname, address etc,) is not mandatory
     *
     * @param  @Valid @RequestBody SignupRequest : the SignupRequest class, stored in payload/request
     * @return different possibilities according to the actions
     * 1. user already exists in the db
     * 2. email already exists in the db
     * 3. ok message
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

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

        Role role = new Role();
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }



    /**
     * User Logout
     * method logout()
     * Allows users to make a clean logout from the app
     * The method cuts the authentication and redirect to the login page.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }


}