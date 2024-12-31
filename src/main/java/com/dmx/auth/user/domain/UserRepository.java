package com.dmx.auth.user.domain;

import java.util.Optional;

public interface UserRepository {
    Optional<User> find(UserEmail email);
    void save(User user);
}
