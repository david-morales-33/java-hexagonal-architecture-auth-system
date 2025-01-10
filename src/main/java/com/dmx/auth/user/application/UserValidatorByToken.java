package com.dmx.auth.user.application;

import com.dmx.auth.token.domain.Token;
import com.dmx.auth.user.domain.AuthService;
import com.dmx.auth.user.domain.TokenNotValid;
import com.dmx.auth.user.domain.User;

public final class UserValidatorByToken {
    private final AuthService service;

    public UserValidatorByToken(AuthService service) {
        this.service = service;
    }

    AuthResponse execute(Token token) throws TokenNotValid {
        boolean status = this.service.validateToken(token);
        if (!status) throw new TokenNotValid("Token no valid");
        User user = this.service.decodedToken(token);
        return new AuthResponse(user.toPrimitives(), token.toPrimitives());
    }
}
