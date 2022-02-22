package com.fastesttyper.fastesttyperservice.infrastructure.persistence.jpa;

import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPA  extends JpaRepository<UserEntity, Long> {
}
