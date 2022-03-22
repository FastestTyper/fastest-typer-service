package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.controller;

import com.fastesttyper.fastesttyperservice.domain.usecase.MarkAsCompletedUseCase;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.mapper.UserMapper;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("typer")
@PreAuthorize("authenticated")
public class LessonController {

    private final UserMapper userMapper;
    private final MarkAsCompletedUseCase markAsCompletedUseCase;

    public LessonController(UserMapper userMapper, MarkAsCompletedUseCase markAsCompletedUseCase) {
        this.userMapper = userMapper;
        this.markAsCompletedUseCase = markAsCompletedUseCase;
    }

    @PostMapping("{userId}/lesson/{lessonId}/completed")
    public ResponseEntity<UserResponse> markLessonAsCompleted(@PathVariable Long userId, @PathVariable Long lessonId) {
        return ResponseEntity.ok(userMapper.toResponse(markAsCompletedUseCase.perform(userId, lessonId)));
    }
}
