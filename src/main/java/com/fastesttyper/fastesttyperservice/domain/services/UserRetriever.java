package com.fastesttyper.fastesttyperservice.domain.services;

import com.fastesttyper.fastesttyperservice.domain.exceptions.UserNotFoundException;
import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.domain.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserRetriever {
    private final UserRepository userRepository;

    public UserRetriever(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
