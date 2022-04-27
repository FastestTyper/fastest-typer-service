package com.fastesttyper.fastesttyperservice.domain.model;

public class Invitation {
    private final Long userId;
    private final Long invitedUserId;

    public Invitation(Long userId, Long invitedUserId) {
        this.userId = userId;
        this.invitedUserId = invitedUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getInvitedUserId() {
        return invitedUserId;
    }
}
