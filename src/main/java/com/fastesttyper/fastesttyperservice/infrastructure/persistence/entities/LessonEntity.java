package com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities;

import javax.persistence.*;

@Entity
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String text;
    @ManyToOne
    private LessonTypeEntity type;

    public LessonEntity(Long id, String title, String text, LessonTypeEntity type) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.type = type;
    }

    public LessonEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LessonTypeEntity getType() {
        return type;
    }

    public void setType(LessonTypeEntity type) {
        this.type = type;
    }
}
