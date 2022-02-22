package com.fastesttyper.fastesttyperservice.infrastructure.persistence.mapper;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(Register register) {
        return new UserEntity(register.getAlias(), register.getEmail(), register.getPassword());
    }
}
