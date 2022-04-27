package com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class GameTextEntity {
    @Id
    private Long id;

    @Lob
    @Column( length = 1000000 )
    private String text;

    public GameTextEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
