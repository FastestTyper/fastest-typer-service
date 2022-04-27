package com.fastesttyper.fastesttyperservice.domain.repositories;

import com.fastesttyper.fastesttyperservice.domain.model.InvitationStatus;
import com.fastesttyper.fastesttyperservice.domain.model.User;

public interface InvitationRepository {
    void send(Long invitedId, User user);
    void accept(Long userId, InvitationStatus invitationStatus, String gameId);
}
