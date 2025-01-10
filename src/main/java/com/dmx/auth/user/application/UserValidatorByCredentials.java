package com.dmx.auth.user.application;

import com.dmx.auth.credentials.domain.Credentials;
import com.dmx.auth.token.domain.Token;
import com.dmx.auth.user.domain.*;

import java.util.Optional;

public final class UserValidatorByCredentials {
    private final UserRepository repository;
    private final AuthService authService;
    private final PasswordService passwordService;

    public UserValidatorByCredentials(
            UserRepository repository,
            AuthService authService,
            PasswordService passwordService
    ) {
        this.repository = repository;
        this.authService = authService;
        this.passwordService = passwordService;
    }

    AuthResponse execute(Credentials credentials) throws UserNotFound, PasswordNotValid {
        Optional<User> response = this.repository.find(credentials.getEmail());
        if (response.isEmpty()) throw new UserNotFound("User not found");
        User user = response.get();
        boolean state = user.validatePassword(this.passwordService, credentials.getPassword());
        if (!state) throw new PasswordNotValid("Password not valid");
        Token token = this.authService.generateToken(user);
        return new AuthResponse(user.toPrimitives(), token.toPrimitives());
    }
}
