package com.fastesttyper.fastesttyperservice.domain.exceptions;

public class GameNotFoundException extends DomainException {
    public GameNotFoundException(String gameId) {
        super("Game with id: " + gameId + " not found");
    }
}
