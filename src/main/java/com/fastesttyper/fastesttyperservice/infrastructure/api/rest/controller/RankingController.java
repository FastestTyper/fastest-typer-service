package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.controller;

import com.fastesttyper.fastesttyperservice.domain.repositories.UserRepository;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.mapper.UserMapper;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.UserResponse;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("typer")
public class RankingController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public RankingController(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @GetMapping("ranking")
    public ResponseEntity<List<UserResponse>> ranking() {
        return ResponseEntity.ok(userRepository.findRanking().stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList()));
    }
}
