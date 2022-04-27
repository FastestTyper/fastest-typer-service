package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model;

public class AcceptResponse {
    private String gameId;

    public AcceptResponse(String gameId) {
        this.gameId = gameId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
