package com.app.FO.mapper.dto.user;

import java.util.List;

public class UserFDTO {
    private Long userId;
    private String username;

    private String password;

    private String email;
    private List<UserRoleDTO> userRoleDTOList;

    public UserFDTO(Long userId, String username, String password, String email, List<UserRoleDTO> userRoleDTOList) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRoleDTOList = userRoleDTOList;
    }

    @Override
    public String toString() {
        return "UserFDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userRoleDTOList=" + userRoleDTOList +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserRoleDTO> getUserRoleDTOList() {
        return userRoleDTOList;
    }

    public void setUserRoleDTOList(List<UserRoleDTO> userRoleDTOList) {
        this.userRoleDTOList = userRoleDTOList;
    }
}
