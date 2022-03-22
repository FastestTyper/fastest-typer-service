package com.fastesttyper.fastesttyperservice.domain.repositories;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User register(Register register);
    Optional<User> findByEmail(String email);
    List<User> findRanking();
}
