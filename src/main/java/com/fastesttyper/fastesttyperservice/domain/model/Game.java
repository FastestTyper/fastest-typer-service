package com.fastesttyper.fastesttyperservice.domain.model;

public class Game {
    private final String gameId;
    private final Long userId;
    private final Long invitingUserId;
    private final String text;

    public Game(String gameId, Long userId, Long invitingUserId, String text) {
        this.gameId = gameId;
        this.userId = userId;
        this.invitingUserId = invitingUserId;
        this.text = text;
    }

    public String getGameId() {
        return gameId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getInvitingUserId() {
        return invitingUserId;
    }

    public String getText() {
        return text;
    }
}
