package com.fastesttyper.fastesttyperservice.domain.usecase;

import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.domain.repositories.UserRepository;
import com.fastesttyper.fastesttyperservice.domain.services.UserRetriever;
import org.springframework.stereotype.Service;

@Service
public class IncreaseRankingUseCase {
    private final UserRetriever userRetriever;
    private final UserRepository userRepository;

    public IncreaseRankingUseCase(UserRetriever userRetriever, UserRepository userRepository) {
        this.userRetriever = userRetriever;
        this.userRepository = userRepository;
    }

    public void increase(Long userId) {
        User user = userRetriever.findById(userId);
        User increasedUser = new User(user.getId(), user.getAlias(), user.getEmail(), user.getPassword(), user.getPoints() + 200);

        userRepository.update(increasedUser);
    }
}
