package com.ioc.easylibapi.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

/**
 * Class Role
 * model type of class, describes the Role object (role table)
 * We define the link between User and Role by a ManyToMany, using the mapping "roles"
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @SequenceGenerator(name = "seq_role", sequenceName = "seq_role", allocationSize = 1)
    @GeneratedValue(generator = "seq_role")
    @Column(name = "role_id", nullable = false)
    Long id;

    @NotEmpty
    @Column(name = "role_name", nullable = false)
    private String roleName;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    @JsonIgnore

    /**
     * Role GETTERS AND SETTERS
     */

    private Set<User> users = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
