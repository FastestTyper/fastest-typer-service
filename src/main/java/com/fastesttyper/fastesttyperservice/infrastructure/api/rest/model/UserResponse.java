package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model;

public class UserResponse {
    private String alias;
    private String email;
    private Integer points;

    public UserResponse(String alias, String email, Integer points) {
        this.alias = alias;
        this.email = email;
        this.points = points;
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
