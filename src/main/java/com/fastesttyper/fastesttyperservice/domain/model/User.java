package com.fastesttyper.fastesttyperservice.domain.model;

public class User {
    private final Long id;
    private final String alias;
    private final String email;
    private final String password;

    public User(Long id, String alias, String email, String password) {
        this.id = id;
        this.alias = alias;
        this.email = email;
        this.password = password;
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
}
