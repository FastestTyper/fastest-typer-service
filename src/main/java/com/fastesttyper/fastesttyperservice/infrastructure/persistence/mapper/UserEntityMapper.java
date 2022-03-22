package com.fastesttyper.fastesttyperservice.infrastructure.persistence.mapper;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {
    private final LessonEntityMapper lessonEntityMapper;

    public UserEntityMapper(LessonEntityMapper lessonEntityMapper) {
        this.lessonEntityMapper = lessonEntityMapper;
    }

    public UserEntity toEntity(Register register) {
        return new UserEntity(register.getAlias(), register.getEmail(), new BCryptPasswordEncoder().encode(register.getPassword()), 0);
    }

    public UserEntity toEntity(User user) {
        return new UserEntity(user.getId(), user.getAlias(), user.getEmail(), user.getPassword(), user.getPoints(), lessonEntityMapper.toEntity(user.getCompletedLessons()));
    }

    public User toDomain(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getAlias(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getPoints(), lessonEntityMapper.toDomain(userEntity.getCompletedLessons()));
    }
}
