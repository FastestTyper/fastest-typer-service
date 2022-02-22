package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.controller;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.domain.usecase.RegisterUseCase;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.mapper.RegisterMapper;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("typer")
public class RegisterController {

    private final RegisterMapper registerMapper;
    private final RegisterUseCase registerUseCase;

    public RegisterController(RegisterMapper registerMapper, RegisterUseCase registerUseCase) {
        this.registerMapper = registerMapper;
        this.registerUseCase = registerUseCase;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        Register register = registerMapper.toDomain(registerRequest);
        registerUseCase.register(register);
        return ResponseEntity.ok(registerRequest.getAlias());
    }
}
