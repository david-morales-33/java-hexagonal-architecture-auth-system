package com.dmx.auth.credentials.domain;

import java.util.UUID;

public final class Credentials {
    private final CredentialId id;
    private final CredentialEmail email;
    private final CredentialPassword password;

    public Credentials(CredentialEmail email, CredentialPassword password) {
        this.id = new CredentialId(UUID.randomUUID().toString());
        this.email = email;
        this.password = password;
    }

    public CredentialId getId() {
        return this.id;
    }

    public CredentialEmail getEmail() {
        return this.email;
    }

    public CredentialPassword getPassword() {
        return this.password;
    }
}
