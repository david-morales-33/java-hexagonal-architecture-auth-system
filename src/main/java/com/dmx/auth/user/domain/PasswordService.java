package com.dmx.auth.user.domain;

import com.dmx.auth.credentials.domain.CredentialPassword;

public interface PasswordService {
    UserHashedPassword encrypt(CredentialPassword password);

    boolean validate(CredentialPassword password, UserHashedPassword hashedPassword);
}
