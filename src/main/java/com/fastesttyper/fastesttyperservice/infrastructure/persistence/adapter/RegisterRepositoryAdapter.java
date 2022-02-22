package com.fastesttyper.fastesttyperservice.infrastructure.persistence.adapter;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.domain.repositories.RegisterRepository;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.UserEntity;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.jpa.UserJPA;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class RegisterRepositoryAdapter implements RegisterRepository {
    private final UserMapper userMapper;
    private final UserJPA userJPA;

    public RegisterRepositoryAdapter(UserMapper userMapper, UserJPA userJPA) {
        this.userMapper = userMapper;
        this.userJPA = userJPA;
    }

    @Override
    public void register(Register register) {
        UserEntity userEntity = userMapper.toEntity(register);
        userJPA.save(userEntity);
    }
}
