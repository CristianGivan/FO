package com.app.FO.dto.user;

import com.app.FO.model.user.Role;

import java.time.LocalDateTime;

public class UserRoleDTO {
    private Long userRoleId;
    private String roleType;
    private String allocatedDate;

    @Override
    public String toString() {
        return "UserRoleDTO{" +
                "userRoleId=" + userRoleId +
                ", roleType=" + roleType +
                ", allocatedDate=" + allocatedDate +
                '}';
    }

    public UserRoleDTO(Long userRoleId, String roleType, String allocatedDate) {
        this.userRoleId = userRoleId;
        this.roleType = roleType;
        this.allocatedDate = allocatedDate;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getAllocatedDate() {
        return allocatedDate;
    }

    public void setAllocatedDate(String allocatedDate) {
        this.allocatedDate = allocatedDate;
    }
}
