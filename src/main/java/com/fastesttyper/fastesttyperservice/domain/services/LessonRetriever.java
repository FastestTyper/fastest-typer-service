package com.fastesttyper.fastesttyperservice.domain.services;

import com.fastesttyper.fastesttyperservice.domain.exceptions.LessonNotFoundException;
import com.fastesttyper.fastesttyperservice.domain.model.Lesson;
import com.fastesttyper.fastesttyperservice.domain.repositories.LessonRepository;
import org.springframework.stereotype.Component;

@Component
public class LessonRetriever {
    private final LessonRepository lessonRepository;

    public LessonRetriever(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson findById(Long id) {
        return this.lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException(id));
    }
}
