package com.app.FO.mapper.dto.user;

import com.app.FO.mapper.dto.tag.TagDTO;

import java.util.List;

public class UserFDTO {
    private Long userId;
    private String username;

    private String password;

    private String email;
    private List<UserRoleDTO> userRoleDTOList;

    private List<UserDTO> userDTOList;

    private List<TagDTO> tagDTOList;

    public UserFDTO(Long userId, String username, String password, String email, List<UserRoleDTO> userRoleDTOList, List<UserDTO> userDTOList, List<TagDTO> tagDTOList) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRoleDTOList = userRoleDTOList;
        this.userDTOList = userDTOList;
        this.tagDTOList = tagDTOList;
    }

    @Override
    public String toString() {
        return "UserFDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userRoleDTOList=" + userRoleDTOList +
                ", userDTOList=" + userDTOList +
                ", tagDTOList=" + tagDTOList +
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

    public List<UserDTO> getUserDTOList() {
        return userDTOList;
    }

    public void setUserDTOList(List<UserDTO> userList) {
        this.userDTOList = userList;
    }

    public List<TagDTO> getTagDTOList() {
        return tagDTOList;
    }

    public void setTagDTOList(List<TagDTO> tagDTOList) {
        this.tagDTOList = tagDTOList;
    }
}
