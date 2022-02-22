package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.mapper;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapper {

    public Register toDomain(RegisterRequest registerRequest) {
        return new Register(registerRequest.getAlias(), registerRequest.getEmail(), registerRequest.getPassword());
    }
}
