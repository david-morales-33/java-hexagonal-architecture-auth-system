package com.dmx.auth.user.domain;

import com.dmx.auth.credentials.domain.CredentialPassword;
import com.dmx.auth.role.domain.Role;
import com.dmx.auth.role.domain.RoleDTO;

import java.util.ArrayList;
import java.util.List;

public final class User {
    private final UserId id;
    private final UserName name;
    private final UserEmail email;
    private final UserHashedPassword hashedPassword;
    private final List<Role> roleList;

    public User(UserId id, UserName name, UserEmail email, UserHashedPassword hashedPassword, List<Role> RoleList) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.hashedPassword = hashedPassword;
        this.roleList = RoleList;
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

    public List<Role> getRoleList() {
        return this.roleList;
    }

    public boolean validatePassword(PasswordService service, CredentialPassword password) {
        return service.validate(password, this.hashedPassword);
    }

    public static User fromPrimitives(UserDTO data) {
        List<Role> roleList = new ArrayList<>();
        data.getRoleList().forEach(element -> roleList.add(Role.fromPrimitives(element)));

        return new User(
                new UserId(data.getId()),
                new UserName(data.getName()),
                new UserEmail(data.getEmail()),
                new UserHashedPassword(data.getHashedPassword()),
                roleList);
    }

    public UserDTO toPrimitives() {
        List<RoleDTO> roleList = new ArrayList<>();
        this.roleList.forEach(element -> roleList.add(element.toPrimitives()));
        return new UserDTO(
                this.id.value(),
                this.name.value(),
                this.email.value(),
                this.hashedPassword.value(),
                roleList);
    }
}
