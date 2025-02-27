package com.dmx.auth.user.infrastructure.persistence;

import java.util.List;
import java.util.Set;

import com.dmx.auth.role.domain.RoleDTO;
import com.dmx.auth.role.infrastructure.persistence.RoleEntity;
import com.dmx.auth.user.domain.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tbl_user")
public class UserEntity extends UserDTO {
    public UserEntity(String id, String name, String email, String hashedPassword, List<RoleDTO> roleList) {
        super(id, name, email, hashedPassword, roleList);
    }

    public UserEntity() {
    }

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

    @ManyToMany(targetEntity = RoleEntity.class)
    @JoinTable(
        name = "tbl_user_x_role", 
        joinColumns = @JoinColumn(name = "usr_id"), 
        inverseJoinColumns = @JoinColumn(name = "rol_id")
        )
    private Set<RoleEntity> roleList;

}
