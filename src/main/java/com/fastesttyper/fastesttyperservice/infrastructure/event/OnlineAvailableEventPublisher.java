package com.fastesttyper.fastesttyperservice.infrastructure.event;

import com.fastesttyper.fastesttyperservice.domain.model.InvitationStatus;
import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.domain.repositories.InvitationRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class OnlineAvailableEventPublisher implements InvitationRepository {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public OnlineAvailableEventPublisher(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void changeAvailablePublisher(){
        simpMessagingTemplate.convertAndSend("/topic/availables" ,"CHANGE" );
    }

    @Override
    public void send(Long invitedId, User user) {
        simpMessagingTemplate.convertAndSend("/topic/invitation" + invitedId, user);
    }

    @Override
    public void accept(Long userId, InvitationStatus invitationStatus, String gameId) {
        if(invitationStatus == InvitationStatus.NO) {
            simpMessagingTemplate.convertAndSend("/topic/accepting" + userId, invitationStatus);
        } else {
            simpMessagingTemplate.convertAndSend("/topic/accepting" + userId, gameId);
        }
    }

    public void sendText(Long userId, String text) {
        simpMessagingTemplate.convertAndSend("/topic/game" + userId, text);
    }
}
