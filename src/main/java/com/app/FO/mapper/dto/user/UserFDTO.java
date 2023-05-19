package com.app.FO.mapper.dto.user;

import java.util.List;

public class UserFDTO {
    private Long userId;
    private String username;
    private List<UserRoleDTO> userRoleDTOList;
    private List<UserTagDTO> userTagDTOList;

    public UserFDTO(Long userId, String username, List<UserRoleDTO> userRoleDTOList, List<UserTagDTO> userTagDTOList) {
        this.userId = userId;
        this.username = username;
        this.userRoleDTOList = userRoleDTOList;
        this.userTagDTOList = userTagDTOList;
    }

    @Override
    public String toString() {
        return "UserFDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userRoles=" + userRoleDTOList +
                ", userTags=" + userTagDTOList +
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

    public List<UserTagDTO> getUserTagDTOList() {
        return userTagDTOList;
    }

    public void setUserTagDTOList(List<UserTagDTO> userTagDTOList) {
        this.userTagDTOList = userTagDTOList;
    }
}
