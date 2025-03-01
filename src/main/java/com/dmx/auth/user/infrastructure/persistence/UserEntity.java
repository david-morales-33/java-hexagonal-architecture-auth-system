package com.dmx.auth.user.infrastructure.persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dmx.auth.role.domain.Role;
import com.dmx.auth.role.domain.RoleId;
import com.dmx.auth.role.domain.RoleLabel;
import com.dmx.auth.role.infrastructure.persistence.RoleEntity;
import com.dmx.auth.user.domain.User;
import com.dmx.auth.user.domain.UserEmail;
import com.dmx.auth.user.domain.UserHashedPassword;
import com.dmx.auth.user.domain.UserId;
import com.dmx.auth.user.domain.UserName;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tbl_user")
public class UserEntity {
    @Id
    @Column(name = "usr_id", length = 36)
    private String id;

    @Column(name = "usr_name", length = 100, nullable = false)
    private String name;

    @Email
    @Column(name = "usr_email", nullable = false)
    private String email;

    @Column(name = "usr_password", nullable = false)
    private String hashedPassword;

    @ManyToMany(targetEntity = RoleEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "tbl_user_x_role", joinColumns = @JoinColumn(name = "usr_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<RoleEntity> roleList;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public Set<RoleEntity> getRoleList() {
        return roleList;
    }

    public UserEntity() {
    }

    public UserEntity(String id, String name, @Email String email, String hashedPassword, Set<RoleEntity> roleList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.roleList = roleList;
    }

    public static UserEntity fromDomain(User user) {

        Set<RoleEntity> roleList = new HashSet<>();
        for (Role role : user.getRoleList()) {
            RoleEntity newRole = new RoleEntity(role.getId().value(), role.getLabel().value());
            roleList.add(newRole);
        }
        return new UserEntity(
                user.getId().value(),
                user.getName().value(),
                user.getEmail().value(),
                user.getHashedPassword().value(),
                roleList);
    }

    public User toDomain() {
        List<Role> roleList = new ArrayList<>();
        for (RoleEntity role : this.roleList) {
            Role newRole = new Role(new RoleId(role.getId()), new RoleLabel(role.getLabel()));
            roleList.add(newRole);
        }
        return new User(
                new UserId(id),
                new UserName(name),
                new UserEmail(email),
                new UserHashedPassword(hashedPassword),
                roleList);
    }

}
