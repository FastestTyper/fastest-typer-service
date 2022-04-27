package com.fastesttyper.fastesttyperservice.domain.repositories;

import com.fastesttyper.fastesttyperservice.domain.model.User;

import java.util.List;

public interface OnlineAvailableRepository {
    void available(User user);
    void notAvailable(User user);

    List<User> availables();
}
