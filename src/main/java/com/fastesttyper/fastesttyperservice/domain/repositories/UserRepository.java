package com.fastesttyper.fastesttyperservice.domain.repositories;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    void register(Register register);
    Optional<User> findByEmail(String email);
}
