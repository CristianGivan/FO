package com.app.FO.mapper.dto.user;

import java.util.List;

public class UserDTO {
    private Long userId;
    private String username;

    private String password;

    private String email;
/*    private List<UserRole> userRoleList;

    public UserDTO(Long userId, String username, String password, String email, List<UserRole> userRoleList) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRoleList = userRoleList;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }*/

    private List<UserRoleDTO> userRoleDTOList;

    public UserDTO(Long userId, String username, String password, String email, List<UserRoleDTO> userRoleDTOList) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRoleDTOList = userRoleDTOList;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userRoleDTOList=" + userRoleDTOList +
                '}';
    }

    public List<UserRoleDTO> getUserRoleDTOList() {
        return userRoleDTOList;
    }

    public void setUserRoleDTOList(List<UserRoleDTO> userRoleDTOList) {
        this.userRoleDTOList = userRoleDTOList;
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


}
