package com.fastesttyper.fastesttyperservice.domain.usecase;

import com.fastesttyper.fastesttyperservice.domain.model.Lesson;
import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.domain.repositories.UserRepository;
import com.fastesttyper.fastesttyperservice.domain.services.LessonRetriever;
import com.fastesttyper.fastesttyperservice.domain.services.UserRetriever;
import org.springframework.stereotype.Service;

@Service
public class MarkAsCompletedUseCase {

    private final UserRetriever userRetriever;
    private final LessonRetriever lessonRetriever;
    private final UserRepository userRepository;

    public MarkAsCompletedUseCase(UserRetriever userRetriever, LessonRetriever lessonRetriever, UserRepository userRepository) {
        this.userRetriever = userRetriever;
        this.lessonRetriever = lessonRetriever;
        this.userRepository = userRepository;
    }

    public User perform(Long userId, Long lessonId) {
        User user = userRetriever.findById(userId);
        Lesson lesson = lessonRetriever.findById(lessonId);
        if (user.containLessonAsCompleted(lesson)) return user;
        user.addLessonAsCompleted(lesson);
        return userRepository.update(user);
    }
}
