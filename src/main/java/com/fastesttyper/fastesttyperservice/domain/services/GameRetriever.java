package com.fastesttyper.fastesttyperservice.domain.services;

import com.fastesttyper.fastesttyperservice.domain.exceptions.GameNotFoundException;
import com.fastesttyper.fastesttyperservice.domain.model.Game;
import com.fastesttyper.fastesttyperservice.domain.repositories.GameRepository;
import org.springframework.stereotype.Component;

@Component
public class GameRetriever {

    private final GameRepository gameRepository;

    public GameRetriever(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game retrieve(String id) {
       return gameRepository.findById(id)
               .orElseThrow(() -> new GameNotFoundException(id));
   }
}
