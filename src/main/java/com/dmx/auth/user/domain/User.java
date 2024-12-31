package com.dmx.auth.user.domain;

public final class User {
    private final UserId id;
    private final UserName name;
    private final UserEmail email;
    private final UserHashedPassword hashedPassword;

    public User(UserId id, UserName name, UserEmail email, UserHashedPassword hashedPassword) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.hashedPassword = hashedPassword;
    }

    public UserId getId() {
        return this.id;
    }

    public UserName getName() {
        return this.name;
    }

    public UserEmail getEmail() {
        return this.email;
    }

    public UserHashedPassword getHashedPassword() {
        return this.hashedPassword;
    }

    public static User fromPrimitives(UserDTO data) {
        return new User(
                new UserId(data.id()),
                new UserName(data.name()),
                new UserEmail(data.email()),
                new UserHashedPassword(data.hashedPassword())
        );
    }

    public UserDTO toPrimitives() {
        return new UserDTO(
                this.id.value(),
                this.name.value(),
                this.email.value(),
                this.hashedPassword.value()
        );
    }
}
