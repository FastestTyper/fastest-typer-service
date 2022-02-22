package com.fastesttyper.fastesttyperservice.infrastructure.persistence.adapter;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.domain.repositories.UserRepository;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.UserEntity;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.jpa.UserJPA;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepository {
    private final UserMapper userMapper;
    private final UserJPA userJPA;

    public UserRepositoryAdapter(UserMapper userMapper, UserJPA userJPA) {
        this.userMapper = userMapper;
        this.userJPA = userJPA;
    }

    @Override
    public void register(Register register) {
        UserEntity userEntity = userMapper.toEntity(register);
        userJPA.save(userEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJPA.findByEmail(email)
                .map(userMapper::toDomain)
                .or(Optional::empty);
    }
}
