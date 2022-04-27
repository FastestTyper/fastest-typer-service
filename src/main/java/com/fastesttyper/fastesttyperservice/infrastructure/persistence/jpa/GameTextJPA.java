package com.fastesttyper.fastesttyperservice.infrastructure.persistence.jpa;

import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.GameTextEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameTextJPA extends JpaRepository<GameTextEntity, Long> {
    GameTextEntity findTop1ByOrderByIdDesc();
}
