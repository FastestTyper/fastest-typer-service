package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.mapper;

import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getAlias(), user.getEmail(), user.getPoints(), user.getCompletedLessons());
    }
}
