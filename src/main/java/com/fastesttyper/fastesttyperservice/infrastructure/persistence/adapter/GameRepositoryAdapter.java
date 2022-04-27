package com.fastesttyper.fastesttyperservice.infrastructure.persistence.adapter;

import com.fastesttyper.fastesttyperservice.domain.model.Game;
import com.fastesttyper.fastesttyperservice.domain.repositories.GameRepository;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.GameTextEntity;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.jpa.GameJPA;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.jpa.GameTextJPA;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.mapper.GameEntityMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Random;

@Component
public class GameRepositoryAdapter implements GameRepository {

    private final GameJPA gameJPA;
    private final GameTextJPA gameTextJPA;
    private final GameEntityMapper gameEntityMapper;

    public GameRepositoryAdapter(GameJPA gameJPA, GameTextJPA gameTextJPA, GameEntityMapper gameEntityMapper) {
        this.gameJPA = gameJPA;
        this.gameTextJPA = gameTextJPA;
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

    @Override
    public String retrieveRandomText() {
        Integer maxId = Math.toIntExact(this.gameTextJPA.findTop1ByOrderByIdDesc().getId() + 1);
        GameTextEntity gameTextEntity = gameTextJPA.getById((long) new Random().nextInt(maxId));
        return gameTextEntity.getText();
    }
}
