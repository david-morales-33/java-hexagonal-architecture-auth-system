package com.dmx.auth.user.domain;

public class PasswordNotValid extends RuntimeException {
    public PasswordNotValid(String message) {
        super(message);
    }
}
