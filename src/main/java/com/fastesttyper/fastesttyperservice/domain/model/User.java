package com.fastesttyper.fastesttyperservice.domain.model;

public class User {
    private final Long id;
    private final String alias;
    private final String email;
    private final String password;
    private final Integer points;

    public User(Long id, String alias, String email, String password, Integer points) {
        this.id = id;
        this.alias = alias;
        this.email = email;
        this.password = password;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPoints() {
        return points;
    }
}
