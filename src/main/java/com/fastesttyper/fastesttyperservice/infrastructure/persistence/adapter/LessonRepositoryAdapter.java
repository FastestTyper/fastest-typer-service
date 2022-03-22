package com.fastesttyper.fastesttyperservice.infrastructure.persistence.adapter;

import com.fastesttyper.fastesttyperservice.domain.model.Lesson;
import com.fastesttyper.fastesttyperservice.domain.repositories.LessonRepository;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.jpa.LessonJPA;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.mapper.LessonEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LessonRepositoryAdapter implements LessonRepository {
    private final LessonEntityMapper lessonEntityMapper;
    private final LessonJPA lessonJPA;

    public LessonRepositoryAdapter(LessonEntityMapper lessonEntityMapper, LessonJPA lessonJPA) {
        this.lessonEntityMapper = lessonEntityMapper;
        this.lessonJPA = lessonJPA;
    }

    @Override
    public Optional<Lesson> findById(Long id) {
        return lessonJPA.findById(id)
                .map(lessonEntityMapper::toDomain)
                .or(Optional::empty);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonEntityMapper.toDomain(lessonJPA.findAll());
    }
}
