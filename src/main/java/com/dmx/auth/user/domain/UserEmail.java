package com.dmx.auth.user.domain;

import com.dmx.auth.shared.domain.StringValueObject;
import com.dmx.auth.shared.exceptions.DomainException;

public class UserEmail extends StringValueObject {
    public UserEmail(String value) {
        super(value);
        this.ensureValidEmail(value);
    }

    private void ensureValidEmail(String value) {
        if (!value.contains("@")) throw new DomainException("Email not valid");
    }
}
