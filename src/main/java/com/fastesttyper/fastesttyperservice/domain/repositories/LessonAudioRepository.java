package com.fastesttyper.fastesttyperservice.domain.repositories;

import com.fastesttyper.fastesttyperservice.domain.model.Lesson;

public interface LessonAudioRepository {
    boolean existAudio(Lesson lesson);
    String createAudio(Lesson lesson);
    String generateDefaultUrl(Lesson lesson);
}
