package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.controller;

import com.fastesttyper.fastesttyperservice.domain.model.Lesson;
import com.fastesttyper.fastesttyperservice.domain.model.UserLesson;
import com.fastesttyper.fastesttyperservice.domain.services.LessonRetriever;
import com.fastesttyper.fastesttyperservice.domain.usecase.MarkAsCompletedUseCase;
import com.fastesttyper.fastesttyperservice.domain.usecase.RetrieveLessonsForUserUseCase;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.mapper.UserMapper;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("typer")
@PreAuthorize("authenticated")
public class LessonController {

    private final UserMapper userMapper;
    private final MarkAsCompletedUseCase markAsCompletedUseCase;
    private final RetrieveLessonsForUserUseCase retrieveLessonsForUserUseCase;
    private final LessonRetriever lessonRetriever;

    public LessonController(UserMapper userMapper,
                            MarkAsCompletedUseCase markAsCompletedUseCase,
                            RetrieveLessonsForUserUseCase retrieveLessonsForUserUseCase,
                            LessonRetriever lessonRetriever) {
        this.userMapper = userMapper;
        this.markAsCompletedUseCase = markAsCompletedUseCase;
        this.retrieveLessonsForUserUseCase = retrieveLessonsForUserUseCase;
        this.lessonRetriever = lessonRetriever;
    }

    @PostMapping("{userId}/lesson/{lessonId}/completed")
    public ResponseEntity<UserResponse> markLessonAsCompleted(@PathVariable Long userId, @PathVariable Long lessonId) {
        return ResponseEntity.ok(userMapper.toResponse(markAsCompletedUseCase.perform(userId, lessonId)));
    }

    @GetMapping("{userId}/lesson")
    public ResponseEntity<List<UserLesson>> retrieveAllByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(retrieveLessonsForUserUseCase.retrieve(userId));
    }

    @GetMapping("lesson/{lessonId}")
    public ResponseEntity<Lesson> retrieveById(@PathVariable Long lessonId) {
        return ResponseEntity.ok(lessonRetriever.findById(lessonId));
    }
}
