package com.dmx.auth.user.domain;

public class TokenNotValid extends RuntimeException {
    public TokenNotValid(String message) {
        super(message);
    }
}
