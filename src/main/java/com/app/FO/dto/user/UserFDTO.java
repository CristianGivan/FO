package com.app.FO.dto.user;

import java.util.List;

public class UserFDTO {
    private Long userId;
    private String username;
    private List<UserRoleDTO> userRoles;
    private List<UserTagDTO> userTags;

    @Override
    public String toString() {
        return "UserFDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userRoles=" + userRoles +
                ", userTags=" + userTags +
                '}';
    }

    public UserFDTO(Long userId, String username, List<UserRoleDTO> userRoles, List<UserTagDTO> userTags) {
        this.userId = userId;
        this.username = username;
        this.userRoles = userRoles;
        this.userTags = userTags;
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

    public List<UserTagDTO> getUserTags() {
        return userTags;
    }

    public void setUserTags(List<UserTagDTO> userTags) {
        this.userTags = userTags;
    }
}
