package com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OnlineAvailableUserEntity {

    @Id
    private Long id;

    private String alias;

    private String email;

    private Integer points;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
