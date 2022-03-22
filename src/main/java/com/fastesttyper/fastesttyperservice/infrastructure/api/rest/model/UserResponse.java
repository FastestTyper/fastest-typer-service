package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model;

import com.fastesttyper.fastesttyperservice.domain.model.Lesson;

import java.util.List;

public class UserResponse {
    private Long id;
    private String alias;
    private String email;
    private Integer points;
    private List<Lesson> completedLessons;

    public UserResponse(Long id, String alias, String email, Integer points, List<Lesson> completedLessons) {
        this.id = id;
        this.alias = alias;
        this.email = email;
        this.points = points;
        this.completedLessons = completedLessons;
    }

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

    public List<Lesson> getCompletedLessons() {
        return completedLessons;
    }

    public void setCompletedLessons(List<Lesson> completedLessons) {
        this.completedLessons = completedLessons;
    }
}
