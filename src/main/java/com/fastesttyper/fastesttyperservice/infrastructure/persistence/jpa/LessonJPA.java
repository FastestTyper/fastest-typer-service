package com.fastesttyper.fastesttyperservice.infrastructure.persistence.jpa;

import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonJPA extends JpaRepository<LessonEntity, Long> {
}
