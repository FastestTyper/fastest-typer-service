package com.fastesttyper.fastesttyperservice.domain.model;

public class UserLesson {
    private final Lesson lesson;
    private final boolean completed;

    public UserLesson(Lesson lesson, boolean completed) {
        this.lesson = lesson;
        this.completed = completed;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public boolean isCompleted() {
        return completed;
    }
}
