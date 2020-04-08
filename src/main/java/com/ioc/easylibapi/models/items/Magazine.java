package com.ioc.easylibapi.models.items;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Magazine  extends Item{

    @Column(nullable = true)
    private  Integer number;

    /**
     * Magazine GETTERS AND SETTERS
     */

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
