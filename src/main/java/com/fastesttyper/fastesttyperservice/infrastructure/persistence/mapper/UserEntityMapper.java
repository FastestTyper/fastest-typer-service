package com.fastesttyper.fastesttyperservice.infrastructure.persistence.mapper;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {
    public UserEntity toEntity(Register register) {
        return new UserEntity(register.getAlias(), register.getEmail(), new BCryptPasswordEncoder().encode(register.getPassword()));
    }

    public User toDomain(UserEntity userEntity) {
        return new User(userEntity.getAlias(), userEntity.getEmail(), userEntity.getPassword());
    }
}
