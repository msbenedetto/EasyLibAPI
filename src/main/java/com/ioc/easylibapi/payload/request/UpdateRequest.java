package com.ioc.easylibapi.payload.request;

import com.ioc.easylibapi.models.user.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Class UpdateRequest
 * defines the elements sent by the user to update his data
 * Cannot be empty: username, password, email
 */
public class UpdateRequest {
    @NotBlank
    private String username;

    @Email
    private String email;
    private List<Role> role;
    private String firstname;
    private String lastname;
    private String cellphone;
    private String address;
    private int zipcode;
    private String city;
    private String country;

    /**
     * UpdateRequest()
     * builder of the class
     */
    public UpdateRequest() {
    }

    /**
     * UpdateRequest getters and setters
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
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
}
