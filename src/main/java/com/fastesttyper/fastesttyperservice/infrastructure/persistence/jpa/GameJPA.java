package com.fastesttyper.fastesttyperservice.infrastructure.persistence.jpa;

import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameJPA extends JpaRepository<GameEntity, String> {
}
