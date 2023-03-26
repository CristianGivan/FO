package com.app.FO.dto.user;

import java.util.List;

public class UserDTO {
    private Long userId;
    private String username;

    //shall I keep in UserDTO UserRoles?
    private List<UserRoleDTO> userRoleDTOList;

    public UserDTO(Long id, String username, List<UserRoleDTO> role) {
        this.userId = id;
        this.username = username;
        this.userRoleDTOList = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", roles=" + userRoleDTOList +
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
