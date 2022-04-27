package com.fastesttyper.fastesttyperservice.domain.usecase;

import com.fastesttyper.fastesttyperservice.domain.model.Invitation;
import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.domain.repositories.InvitationRepository;
import com.fastesttyper.fastesttyperservice.domain.services.UserRetriever;
import org.springframework.stereotype.Service;

@Service
public class SendInvitationUseCase {

    private final UserRetriever userRetriever;
    private final InvitationRepository invitationRepository;

    public SendInvitationUseCase(UserRetriever userRetriever, InvitationRepository invitationRepository) {
        this.userRetriever = userRetriever;
        this.invitationRepository = invitationRepository;
    }

    public void send(Invitation invitation) {
        User user = userRetriever.findById(invitation.getUserId());
        User invitedUsed = userRetriever.findById(invitation.getInvitedUserId());
        invitationRepository.send(invitedUsed.getId(), user);

    }
}
