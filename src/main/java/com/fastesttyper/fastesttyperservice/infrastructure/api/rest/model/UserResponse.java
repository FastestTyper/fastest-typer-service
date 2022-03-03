package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model;

public class UserResponse {
    private String alias;
    private String email;

    public UserResponse(String alias, String email) {
        this.alias = alias;
        this.email = email;
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
}
