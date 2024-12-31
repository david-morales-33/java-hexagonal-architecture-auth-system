package com.dmx.auth.user.domain;

public record UserDTO(
        String name,
        String email,
        String id,
        String hashedPassword
) {
}
