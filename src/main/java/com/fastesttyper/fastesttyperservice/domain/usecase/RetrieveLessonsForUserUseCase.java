package com.fastesttyper.fastesttyperservice.domain.usecase;

import com.fastesttyper.fastesttyperservice.domain.model.Lesson;
import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.domain.model.UserLesson;
import com.fastesttyper.fastesttyperservice.domain.repositories.LessonRepository;
import com.fastesttyper.fastesttyperservice.domain.services.UserRetriever;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetrieveLessonsForUserUseCase {
    private final UserRetriever userRetriever;
    private final LessonRepository lessonRepository;

    public RetrieveLessonsForUserUseCase(UserRetriever userRetriever, LessonRepository lessonRepository) {
        this.userRetriever = userRetriever;
        this.lessonRepository = lessonRepository;
    }

    public List<UserLesson> retrieve(Long id) {
        User user = userRetriever.findById(id);
        List<Lesson> lessons = lessonRepository.findAll();
        List<UserLesson> userLessons = new ArrayList<>();
        for(Lesson lesson : lessons) {
            if(user.containLessonAsCompleted(lesson)){
                userLessons.add(new UserLesson(lesson, true));
            } else {
                userLessons.add(new UserLesson(lesson, false));
            }
        }
        return userLessons;
    }
}
