package com.dmx.auth.role.infrastructure.persistence;

import com.dmx.auth.role.domain.Role;
import com.dmx.auth.role.domain.RoleId;
import com.dmx.auth.role.domain.RoleLabel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_role")
public class RoleEntity {
    @Id
    @Column(name = "rol_id")
    private int id;

    @Column(name = "rol_label", nullable = false, length = 50)
    private String label;

    public RoleEntity() {
    }

    public RoleEntity(int id, String label) {
        this.id = id;
        this.label = label;
    }
    
    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static RoleEntity fromDomain(Role role) {
        return new RoleEntity(role.getId().value(), role.getLabel().value());
    }

    public Role toDomain() {
        return new Role(new RoleId(id), new RoleLabel(label));
    }

}
