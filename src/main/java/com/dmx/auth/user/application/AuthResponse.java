package com.dmx.auth.user.application;

import com.dmx.auth.token.domain.TokenDTO;
import com.dmx.auth.user.domain.UserDTO;

public record AuthResponse(UserDTO user, TokenDTO token) {
}
