package com.fastesttyper.fastesttyperservice.domain.usecase;

import com.fastesttyper.fastesttyperservice.domain.model.Game;
import com.fastesttyper.fastesttyperservice.domain.model.InvitationStatus;
import com.fastesttyper.fastesttyperservice.domain.repositories.GameRepository;
import com.fastesttyper.fastesttyperservice.domain.repositories.InvitationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AcceptInvitationUseCase {
    private final InvitationRepository invitationRepository;
    private final GameRepository gameRepository;

    public AcceptInvitationUseCase(InvitationRepository invitationRepository, GameRepository gameRepository) {
        this.invitationRepository = invitationRepository;
        this.gameRepository = gameRepository;
    }

    public String accept(Long userId, Long invitingUserId, InvitationStatus invitationStatus) {
        String gameId;
        if (invitationStatus == InvitationStatus.NO){
            gameId = "NO";
        }else {
            gameId =  UUID.randomUUID().toString();
        }
        Game game = new Game(gameId, userId, invitingUserId, gameRepository.retrieveRandomText());
        invitationRepository.accept(userId, invitationStatus, gameId);
        if (invitationStatus == InvitationStatus.YES) {
            gameRepository.save(game);
        }

        return gameId;
    }
}
