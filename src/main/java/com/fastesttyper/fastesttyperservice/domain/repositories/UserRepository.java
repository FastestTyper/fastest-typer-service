package com.fastesttyper.fastesttyperservice.domain.repositories;

import com.fastesttyper.fastesttyperservice.domain.model.Register;
import com.fastesttyper.fastesttyperservice.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User register(Register register);
    User update(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    List<User> findRanking();
}
