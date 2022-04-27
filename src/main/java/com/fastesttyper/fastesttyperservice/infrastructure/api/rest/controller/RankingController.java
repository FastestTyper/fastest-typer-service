package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.controller;

import com.fastesttyper.fastesttyperservice.domain.repositories.UserRepository;
import com.fastesttyper.fastesttyperservice.domain.usecase.IncreaseRankingUseCase;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.mapper.UserMapper;
import com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("typer")
public class RankingController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final IncreaseRankingUseCase increaseRankingUseCase;

    public RankingController(UserRepository userRepository, UserMapper userMapper, IncreaseRankingUseCase increaseRankingUseCase) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.increaseRankingUseCase = increaseRankingUseCase;
    }

    @GetMapping("ranking")
    public ResponseEntity<List<UserResponse>> ranking() {
        return ResponseEntity.ok(userRepository.findRanking().stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList()));
    }

    @PutMapping("ranking/{userId}/increase")
    public ResponseEntity<Void> increaseRanking(@PathVariable Long userId) {
        increaseRankingUseCase.increase(userId);
        return ResponseEntity.ok().build();
    }
}
