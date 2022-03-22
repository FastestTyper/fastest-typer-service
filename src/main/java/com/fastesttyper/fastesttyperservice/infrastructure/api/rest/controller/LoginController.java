package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.controller;

import com.fastesttyper.fastesttyperservice.configuration.security.service.JwtService;
import com.fastesttyper.fastesttyperservice.domain.repositories.UserRepository;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("typer")
public class LoginController {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public LoginController(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@AuthenticationPrincipal User activeUser) {
        com.fastesttyper.fastesttyperservice.domain.model.User user = userRepository.findByEmail(activeUser.getUsername()).get();
        return  ResponseEntity.ok(new LoginResponse(jwtService.createToken(activeUser.getUsername(), user.getId().toString())));
    }
}
