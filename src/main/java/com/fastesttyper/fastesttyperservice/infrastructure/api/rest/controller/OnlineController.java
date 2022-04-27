package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.controller;

import com.fastesttyper.fastesttyperservice.domain.model.Game;
import com.fastesttyper.fastesttyperservice.domain.model.Invitation;
import com.fastesttyper.fastesttyperservice.domain.services.GameRetriever;
import com.fastesttyper.fastesttyperservice.domain.usecase.AcceptInvitationUseCase;
import com.fastesttyper.fastesttyperservice.domain.usecase.OnlineAvailableUseCase;
import com.fastesttyper.fastesttyperservice.domain.usecase.SendInvitationUseCase;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.mapper.UserMapper;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.AcceptResponse;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.InvitationRequest;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.SendTextRequest;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.UserResponse;
import com.fastesttyper.fastesttyperservice.infrastructure.event.OnlineAvailableEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("typer/online")
public class OnlineController {

    private final OnlineAvailableUseCase onlineAvailableUseCase;
    private final UserMapper userMapper;
    private final SendInvitationUseCase sendInvitationUseCase;
    private final AcceptInvitationUseCase acceptInvitationUseCase;
    private final GameRetriever gameRetriever;

    private final OnlineAvailableEventPublisher onlineAvailableEventPublisher;

    public OnlineController(OnlineAvailableUseCase onlineAvailableUseCase, UserMapper userMapper, SendInvitationUseCase sendInvitationUseCase, AcceptInvitationUseCase acceptInvitationUseCase, GameRetriever gameRetriever, OnlineAvailableEventPublisher onlineAvailableEventPublisher) {
        this.onlineAvailableUseCase = onlineAvailableUseCase;
        this.userMapper = userMapper;
        this.sendInvitationUseCase = sendInvitationUseCase;
        this.acceptInvitationUseCase = acceptInvitationUseCase;
        this.gameRetriever = gameRetriever;
        this.onlineAvailableEventPublisher = onlineAvailableEventPublisher;
    }

    @PostMapping("{userId}/available")
    public ResponseEntity<Void> available(@PathVariable Long userId) {
        onlineAvailableUseCase.available(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{userId}/notAvailable")
    public ResponseEntity<Void> notAvailable(@PathVariable Long userId) {
        onlineAvailableUseCase.notAvailable(userId);
        return ResponseEntity.ok().build();
    }

   @GetMapping("{userId}/availables")
   public ResponseEntity<List<UserResponse>> availables(@PathVariable Long userId) {
       return ResponseEntity.ok(userMapper.toResponse(onlineAvailableUseCase.availables(userId)));
   }

   @PostMapping("{userId}/invite/{invitedUserId}")
    public ResponseEntity<Void> invitate(@PathVariable Long userId, @PathVariable Long invitedUserId) {
        Invitation invitation = new Invitation(userId, invitedUserId);
        sendInvitationUseCase.send(invitation);
        return ResponseEntity.ok().build();
   }

    @PostMapping("{userId}/accept/{invitingUserId}")
    public ResponseEntity<AcceptResponse> accept(@PathVariable Long userId, @PathVariable Long invitingUserId, @RequestBody InvitationRequest invitationRequest) {
        String gameId = acceptInvitationUseCase.accept(userId, invitingUserId, invitationRequest.getStatus());
        return ResponseEntity.ok(new AcceptResponse(gameId));
    }

    @GetMapping("game/{gameId}")
    public ResponseEntity<Game> game(@PathVariable String gameId) {
        return ResponseEntity.ok(gameRetriever.retrieve(gameId));
    }

    @PostMapping("text/{userId}")
    public ResponseEntity<Void> sendText(@PathVariable Long userId, @RequestBody SendTextRequest sendTextRequest) {
        this.onlineAvailableEventPublisher.sendText(userId, sendTextRequest.getText());
        return ResponseEntity.ok().build();
    }

    @PostMapping("{userId}/win/{gameId}")
    public ResponseEntity<Void> sendWin(@PathVariable Long userId, @PathVariable String gameId) {
        this.onlineAvailableEventPublisher.sendWin(userId, gameId);
        return ResponseEntity.ok().build();
    }
}
