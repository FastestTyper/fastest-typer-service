package com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities;

import javax.persistence.*;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String alias;

    @Column(unique = true)
    private String email;

    private String password;

    public UserEntity() {

    }

    public UserEntity(String alias, String email, String password) {
        this.alias = alias;
        this.email = email;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}