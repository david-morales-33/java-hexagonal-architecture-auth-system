package com.dmx.auth.user.domain;

import com.dmx.auth.role.domain.RoleDTO;

import java.util.List;

public record UserDTO(
        String name,
        String email,
        String id,
        String hashedPassword,
        List<RoleDTO> roleList
) {
}
