package com.fastesttyper.fastesttyperservice.domain.model;

public class User {
    private final String alias;
    private final String email;
    private final String password;

    public User(String alias, String email, String password) {
        this.alias = alias;
        this.email = email;
        this.password = password;
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
