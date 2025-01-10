package com.dmx.auth.user.domain;

import com.dmx.auth.credentials.domain.CredentialEmail;

import java.util.Optional;

public interface UserRepository {
    Optional<User> find(CredentialEmail email);
    void save(User user);
}
