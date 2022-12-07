package com.app.FO.dto.user;

import java.util.List;

public class UserSDTO {
    private Long id;
    private String username;
    private List<String> roles;

    public UserSDTO(Long id, String username, List<String> role) {
        this.id = id;
        this.username = username;
        this.roles = role;
    }

    @Override
    public String toString() {
        return "UserSDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
