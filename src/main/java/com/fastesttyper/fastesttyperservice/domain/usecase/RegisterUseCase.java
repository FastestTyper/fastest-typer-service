package com.fastesttyper.fastesttyperservice.domain.usecase;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.domain.repositories.RegisterRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterUseCase {

    private final RegisterRepository registerRepository;

    public RegisterUseCase(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public void register(Register register) {
        registerRepository.register(register);
    }
}
