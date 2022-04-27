package com.fastesttyper.fastesttyperservice.infrastructure.persistence.adapter;

import com.fastesttyper.fastesttyperservice.domain.model.Game;
import com.fastesttyper.fastesttyperservice.domain.repositories.GameRepository;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.jpa.GameJPA;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.mapper.GameEntityMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GameRepositoryAdapter implements GameRepository {

    private final GameJPA gameJPA;
    private final GameEntityMapper gameEntityMapper;

    public GameRepositoryAdapter(GameJPA gameJPA, GameEntityMapper gameEntityMapper) {
        this.gameJPA = gameJPA;
        this.gameEntityMapper = gameEntityMapper;
    }

    @Override
    public void save(Game game) {
        gameJPA.save(gameEntityMapper.toEntity(game));
    }

    @Override
    public Optional<Game> findById(String id) {
        return gameJPA.findById(id)
                .map(gameEntityMapper::toDomain);
    }
}
