package com.ioc.easylibapi.models.library;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ioc.easylibapi.models.items.Copy;

import javax.persistence.*;
import java.util.List;

/**
 * Class Library
 * model type of class, describes the Library object
 * We consider here the possibility to escalate the app, introducing the possibility to add several libraries to our model
 * Note: we define the link between Library and Copy by putting:
 * OneToMany, since 1 library will have lots of different items
 * cascade.ALL, since if we remove a library we want to also remove the items that no longer belong to the db search
 * orphanRemoval = true, thus specifying that orphaned entities should be removed
 */
@Entity
@Table(name = "library", schema = "public")
public class Library {
    @Id
    @SequenceGenerator(name = "seq_library", sequenceName = "seq_library", allocationSize = 1)
    @GeneratedValue(generator = "seq_library")
    @Column(name = "library_id", nullable = false)
    Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String address;
    @Column(nullable = true)
    private int zipCode;
    @Column(nullable = true)
    private String city;
    @Column(nullable = true)
    private String timetable;
    @Column(nullable = true)
    private String phone;
    @Column(nullable = false)
    private String email;

    @JsonIgnore
    @OneToMany(
            mappedBy = "library",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Copy> copy;


    /**
     * Library GETTERS AND SETTERS
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimetable() {
        return timetable;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Copy> getCopy() {
        return copy;
    }

    public void setCopy(List<Copy> copy) {
        this.copy = copy;
    }
}
