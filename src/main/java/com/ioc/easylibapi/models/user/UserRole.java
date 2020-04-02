package com.ioc.easylibapi.models.user;

import javax.persistence.*;

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
    private User fkUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role fkRole;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFkUser() {
        return fkUser;
    }

    public void setFkUser(User fkUser) {
        this.fkUser = fkUser;
    }

    public Role getFkRole() {
        return fkRole;
    }

    public void setFkRole(Role fkRole) {
        this.fkRole = fkRole;
    }

}
