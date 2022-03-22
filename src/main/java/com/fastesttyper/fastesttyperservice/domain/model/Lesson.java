package com.fastesttyper.fastesttyperservice.domain.model;

import java.util.Objects;

public class Lesson {
    private final Long id;
    private final String title;
    private final String text;
    private final LessonType type;

    public Lesson(Long id, String title, String text, LessonType type) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LessonType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id) && Objects.equals(title, lesson.title) && Objects.equals(text, lesson.text) && type == lesson.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text, type);
    }
}
