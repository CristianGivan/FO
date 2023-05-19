package com.app.FO.mapper.dto.user;

import java.util.List;

public class UserDTO {
    private Long userId;
    private String username;

    private List<UserRoleDTO> userRoleDTOList;

    public UserDTO(Long userId, String username, List<UserRoleDTO> userRoleDTOList) {
        this.userId = userId;
        this.username = username;
        this.userRoleDTOList = userRoleDTOList;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
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

    public List<UserRoleDTO> getUserRoleDTOList() {
        return userRoleDTOList;
    }

    public void setUserRoleDTOList(List<UserRoleDTO> userRoleDTOList) {
        this.userRoleDTOList = userRoleDTOList;
    }
}
