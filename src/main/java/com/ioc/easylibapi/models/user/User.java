package com.ioc.easylibapi.models.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ioc.easylibapi.models.booking.Booking;
import com.ioc.easylibapi.models.loan.Loan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class User
 * model type of class, describes the User object (user table)
 * We define the link between User and the other tables, such as:
 * UserStatus, UserRole, Loan and Booking
 * OneToMany: 1 user may have different roles, status, loan and booking
 * cascade.ALL, since we want all the operations to be authorized on related entities
 * orphanRemoval = true, because if wedelete a user, we want to delete everything that is linked to him/her
 */
@Entity
@Table(name = "user", schema = "public")
public class User implements UserDetails {

    @Id
    @SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1)
    @GeneratedValue(generator = "seq_user")
    @Column(name = "user_id", nullable = false)
    Long id;

    @NotEmpty
    @Column(name = "login", nullable = false)
    private String username;

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String password;

    @NotEmpty
    @Column(name = "email", nullable = false)
    private String email;

    @NotEmpty
    @Column(name = "cellphone", nullable = true)
    private String cellphone;

    @Column(name = "firstname", nullable = true)
    private String firstname;

    @Column(name = "lastname", nullable = true)
    private String lastname;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "zipcode", nullable = true)
    private int zipcode;

    @Column(name = "city", nullable = true)
    private String city;

    @Column(name = "country", nullable = true)
    private String country;

    //@JsonIgnore
    @JsonManagedReference(value="userstatus")
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserStatus> userStatus;

    //@JsonIgnore
    @JsonManagedReference(value="userbooking")
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Booking> booking;

    //@JsonIgnore
    @JsonManagedReference(value="userloan")
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Loan> loan;


    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    //Constructor for the SignupRequest
    public User(String username, String email, String password, String firstname, String lastname, String cellphone, String address, int zipcode, String city, String country, List<Role> roles) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.cellphone = cellphone;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.roles = roles;
    }

    //Constructor for the UpdateRequest
    public User(String username, String email, String firstname, String lastname, String cellphone, String address, int zipcode, String city, String country, List<Role> role) {
        this.email = email;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.cellphone = cellphone;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles == null || roles.isEmpty() ? null : this.roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet());
    }

    /**
     * User GETTERS AND SETTERS
     */

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return id;
    }

    public void setUserId(int Long) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Loan> getLoan() {
        return loan;
    }

    public void setLoan(List<Loan> loan) {
        this.loan = loan;
    }

    public List<UserStatus> getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(List<UserStatus> userStatus) {
        this.userStatus = userStatus;
    }
}
