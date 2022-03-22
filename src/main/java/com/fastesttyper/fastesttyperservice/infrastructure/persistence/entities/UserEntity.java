package com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

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

    @ManyToMany
    private List<LessonEntity> completedLessons;

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    private Integer points;

    public UserEntity() {

    }

    public UserEntity(String alias, String email, String password, Integer points) {
        this.alias = alias;
        this.email = email;
        this.password = password;
        this.points = points;
        this.completedLessons = Collections.emptyList();
    }

    public UserEntity(Long id, String alias, String email, String password, Integer points, List<LessonEntity> lessonEntities) {
        this.id = id;
        this.alias = alias;
        this.email = email;
        this.password = password;
        this.points = points;
        this.completedLessons = lessonEntities;
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

    public List<LessonEntity> getCompletedLessons() {
        return completedLessons;
    }

    public void setCompletedLessons(List<LessonEntity> completedLessons) {
        this.completedLessons = completedLessons;
    }
}
