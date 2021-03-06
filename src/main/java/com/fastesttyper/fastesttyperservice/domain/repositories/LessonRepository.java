package com.fastesttyper.fastesttyperservice.domain.repositories;

import com.fastesttyper.fastesttyperservice.domain.model.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonRepository {
    Optional<Lesson> findById(Long id);
    List<Lesson> findAll();
}
