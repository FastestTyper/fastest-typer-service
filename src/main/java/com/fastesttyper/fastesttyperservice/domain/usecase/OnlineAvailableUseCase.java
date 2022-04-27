package com.fastesttyper.fastesttyperservice.domain.usecase;

import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.domain.repositories.OnlineAvailableRepository;
import com.fastesttyper.fastesttyperservice.domain.services.UserRetriever;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OnlineAvailableUseCase {

    private final UserRetriever userRetriever;
    private final OnlineAvailableRepository onlineAvailableRepository;

    public OnlineAvailableUseCase(UserRetriever userRetriever, OnlineAvailableRepository onlineAvailableRepository) {
        this.userRetriever = userRetriever;
        this.onlineAvailableRepository = onlineAvailableRepository;
    }

    public void available(Long id) {
        User user = userRetriever.findById(id);
        onlineAvailableRepository.available(user);
    }

    public void notAvailable(Long id) {
        User user = userRetriever.findById(id);
        onlineAvailableRepository.notAvailable(user);
    }

    public List<User> availables(Long id) {
        User user = userRetriever.findById(id);
        return onlineAvailableRepository.availables().stream()
                .filter(user1 -> !Objects.equals(user1.getId(), user.getId()))
                .collect(Collectors.toList());
    }
}
