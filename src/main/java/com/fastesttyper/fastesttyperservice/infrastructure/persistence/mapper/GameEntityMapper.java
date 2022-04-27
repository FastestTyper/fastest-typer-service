package com.fastesttyper.fastesttyperservice.infrastructure.persistence.mapper;

import com.fastesttyper.fastesttyperservice.domain.model.Game;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.GameEntity;
import org.springframework.stereotype.Component;

@Component
public class GameEntityMapper {

    public GameEntity toEntity(Game game) {
        return new GameEntity(game.getGameId(), game.getUserId(), game.getInvitingUserId(), game.getText());
    }

    public Game toDomain(GameEntity gameEntity) {
        return new Game(gameEntity.getId(), gameEntity.getUserId(), gameEntity.getInvitingUserId(), gameEntity.getText());
    }
}
