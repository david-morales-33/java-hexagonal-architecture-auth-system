package com.dmx.auth.role.domain;

public final class Role {
    private final RoleId id;
    private final RoleLabel label;

    public Role(RoleId id, RoleLabel label) {
        this.id = id;
        this.label = label;
    }

    public RoleId getId() {
        return this.id;
    }

    public RoleLabel getLabel() {
        return this.label;
    }

    public static Role fromPrimitives(RoleDTO data) {
        return new Role(new RoleId(data.id()), new RoleLabel(data.label()));
    }

    public RoleDTO toPrimitives() {
        return new RoleDTO(this.id.value(), this.label.value());
    }
}
