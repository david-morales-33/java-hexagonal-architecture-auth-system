package com.dmx.auth.user.domain;

import com.dmx.auth.role.domain.RoleDTO;

import java.util.List;

public class UserDTO {
        private String id;
        private String name;
        private String email;
        private String hashedPassword;
        private List<RoleDTO> roleList;

        public UserDTO(String id, String name, String email, String hashedPassword, List<RoleDTO> roleList) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.hashedPassword = hashedPassword;
                this.roleList = roleList;
        }

        public UserDTO() {
        }

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
        public List<RoleDTO> getRoleList() {
                return roleList;
        }

}