package com.fastesttyper.fastesttyperservice.domain.repositories;

import com.fastesttyper.fastesttyperservice.domain.model.Game;

import java.util.Optional;

public interface GameRepository {
    void save(Game game);
    Optional<Game> findById(String id);
}
