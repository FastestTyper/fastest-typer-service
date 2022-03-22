package com.fastesttyper.fastesttyperservice.domain.model;

import java.util.Collections;
import java.util.List;

public class User {
    private final Long id;
    private final String alias;
    private final String email;
    private final String password;
    private final Integer points;
    private final List<Lesson> completedLessons;

    public User(Long id, String alias, String email, String password, Integer points) {
        this.id = id;
        this.alias = alias;
        this.email = email;
        this.password = password;
        this.points = points;
        this.completedLessons = Collections.emptyList();
    }

    public User(Long id, String alias, String email, String password, Integer points, List<Lesson> completedLessons) {
        this.id = id;
        this.alias = alias;
        this.email = email;
        this.password = password;
        this.points = points;
        this.completedLessons = completedLessons;
    }

    public boolean containLessonAsCompleted(Lesson lesson) {
        return completedLessons.contains(lesson);
    }

    public void addLessonAsCompleted(Lesson lesson) {
        this.completedLessons.add(lesson);
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

    public List<Lesson> getCompletedLessons() {
        return completedLessons;
    }
}
