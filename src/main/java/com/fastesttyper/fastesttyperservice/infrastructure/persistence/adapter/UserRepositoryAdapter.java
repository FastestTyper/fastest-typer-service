package com.fastesttyper.fastesttyperservice.infrastructure.persistence.adapter;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.domain.repositories.UserRepository;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.UserEntity;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.jpa.UserJPA;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.mapper.UserEntityMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepository {
    private final UserEntityMapper userEntityMapper;
    private final UserJPA userJPA;

    public UserRepositoryAdapter(UserEntityMapper userEntityMapper, UserJPA userJPA) {
        this.userEntityMapper = userEntityMapper;
        this.userJPA = userJPA;
    }

    @Override
    public User register(Register register) {
        UserEntity userEntity = userEntityMapper.toEntity(register);
        userJPA.save(userEntity);
        return userEntityMapper.toDomain(userEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJPA.findByEmail(email)
                .map(userEntityMapper::toDomain)
                .or(Optional::empty);
    }
}
