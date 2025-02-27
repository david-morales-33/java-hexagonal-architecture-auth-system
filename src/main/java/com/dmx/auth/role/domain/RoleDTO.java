package com.dmx.auth.role.domain;

public class RoleDTO{
    private int id;
    private String label;
    
    public RoleDTO(int id, String label) {
        this.id = id;
        this.label = label;
    }
    public RoleDTO() {
    }
    public int getId() {
        return id;
    }
    public String getLabel() {
        return label;
    }

}
