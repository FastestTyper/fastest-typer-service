package com.fastesttyper.fastesttyperservice.domain.usecase;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterUseCase {

    private final UserRepository userRepository;

    public RegisterUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(Register register) {
        userRepository.register(register);
    }
}
