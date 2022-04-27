package com.fastesttyper.fastesttyperservice.infrastructure.persistence.jpa;

import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.OnlineAvailableUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlineAvailableUserJPA extends JpaRepository<OnlineAvailableUserEntity, Long> {
}
