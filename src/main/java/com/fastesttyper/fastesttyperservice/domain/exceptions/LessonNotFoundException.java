package com.fastesttyper.fastesttyperservice.domain.exceptions;

public class LessonNotFoundException extends DomainException {
    public LessonNotFoundException(Long lessonId) {
        super("Lesson with id: " + lessonId + " not found");
    }
}
