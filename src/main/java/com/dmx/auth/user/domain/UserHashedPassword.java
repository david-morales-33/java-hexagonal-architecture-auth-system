package com.dmx.auth.user.domain;

import com.dmx.auth.shared.domain.StringValueObject;

public class UserHashedPassword extends StringValueObject {
    public UserHashedPassword(String value) {
        super(value);
    }
}
