package com.dmx.auth.role.infrastructure.persistence;

import com.dmx.auth.role.domain.RoleDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_role")
public class RoleEntity extends RoleDTO {
    public RoleEntity(int id, String label) {
        super(id, label);
    }

    public RoleEntity() {
    }

    @Id
    @Column(name = "rol_id")
    private int id;

    @Column(name = "rol_label", nullable = false, length = 50)
    private String label;

}
