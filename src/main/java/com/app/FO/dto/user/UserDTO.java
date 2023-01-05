package com.app.FO.dto.user;

import java.util.List;

public class UserDTO {
    private Long userId;
    private String username;
    private List<UserRoleDTO> userRoles;

    public UserDTO(Long id, String username, List<UserRoleDTO> role) {
        this.userId = id;
        this.username = username;
        this.userRoles = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", roles=" + userRoles +
                '}';
    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserRoleDTO> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoleDTO> userRoles) {
        this.userRoles = userRoles;
    }
}
