package com.app.FO.dto.user;

import java.util.List;

public class UserDTO {
    private Long userId;
    private String username;
    private List<String> roles;

    public UserDTO(Long id, String username, List<String> role) {
        this.userId = id;
        this.username = username;
        this.roles = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", roles=" + roles +
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
