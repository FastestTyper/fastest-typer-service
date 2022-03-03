package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.controller;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.domain.usecase.RegisterUseCase;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.mapper.RegisterMapper;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.mapper.UserMapper;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.RegisterRequest;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("typer")
public class RegisterController {

    private final RegisterMapper registerMapper;
    private final UserMapper userMapper;
    private final RegisterUseCase registerUseCase;

    public RegisterController(RegisterMapper registerMapper, UserMapper userMapper, RegisterUseCase registerUseCase) {
        this.registerMapper = registerMapper;
        this.userMapper = userMapper;
        this.registerUseCase = registerUseCase;
    }

    @PostMapping("register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest) {
        Register register = registerMapper.toDomain(registerRequest);
        User user = registerUseCase.register(register);
        return ResponseEntity.ok(userMapper.toResponse(user));
    }
}
