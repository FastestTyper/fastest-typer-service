package com.fastesttyper.fastesttyperservice.domain.exceptions;

public class UserNotFoundException extends DomainException {

    public UserNotFoundException(Long userId) {
        super("User with id: " + userId + " not found");
    }
}
