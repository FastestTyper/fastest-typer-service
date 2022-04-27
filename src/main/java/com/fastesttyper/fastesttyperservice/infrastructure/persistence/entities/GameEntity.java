package com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class GameEntity {
    @Id
    private String id;

    private Long userId;

    private Long invitingUserId;

    @Lob
    @Column( length = 1000000 )
    private String text;

    public GameEntity(String id, Long userId, Long invitingUserId, String text) {
        this.id = id;
        this.userId = userId;
        this.invitingUserId = invitingUserId;
        this.text = text;
    }

    public GameEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getInvitingUserId() {
        return invitingUserId;
    }

    public void setInvitingUserId(Long invitedId) {
        this.invitingUserId = invitedId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
