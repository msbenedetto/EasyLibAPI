package com.ioc.easylibapi.models.user;

import javax.persistence.*;

/**
 * Class UserRole
 * model type of class, describes the UserRole relationship
 * This class is meant to allow the role assignation to a specified user, making easier the relation between User and Role in this many to many relationship
 */
@Entity
@Table(name = "user_role", schema = "public")
public class UserRole {


    @Id
    @SequenceGenerator(name = "seq_ur", sequenceName = "seq_ur", allocationSize = 1)
    @GeneratedValue(generator = "seq_ur")
    @Column(name = "ur_id")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    /**
     * UserRole GETTERS AND SETTERS
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
