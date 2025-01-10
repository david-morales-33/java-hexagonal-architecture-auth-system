package com.dmx.auth.user.domain;

import com.dmx.auth.token.domain.Token;

public interface AuthService {
    Token generateToken(User user);

    User decodedToken(Token token);

    boolean validateToken(Token token);
}
