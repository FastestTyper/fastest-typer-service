package com.fastesttyper.fastesttyperservice.domain.services;

import com.fastesttyper.fastesttyperservice.domain.exceptions.LessonNotFoundException;
import com.fastesttyper.fastesttyperservice.domain.model.Lesson;
import com.fastesttyper.fastesttyperservice.domain.repositories.LessonAudioRepository;
import com.fastesttyper.fastesttyperservice.domain.repositories.LessonRepository;
import org.springframework.stereotype.Component;

@Component
public class LessonRetriever {
    private final LessonRepository lessonRepository;
    private final LessonAudioRepository lessonAudioRepository;

    public LessonRetriever(LessonRepository lessonRepository, LessonAudioRepository lessonAudioRepository) {
        this.lessonRepository = lessonRepository;
        this.lessonAudioRepository = lessonAudioRepository;
    }

    public Lesson findById(Long id) {
        Lesson lesson = this.lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException(id));

        if(lesson.isVideo()) return lesson;
        if(lessonAudioRepository.existAudio(lesson)) {
            lesson.setAudioUrl(lessonAudioRepository.generateDefaultUrl(lesson));
        } else {
            String url = lessonAudioRepository.createAudio(lesson);
            lesson.setAudioUrl(url);
        }
        return lesson;
    }

}
