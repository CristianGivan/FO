package com.app.FO.dto.user;

import com.app.FO.model.user.Role;

import java.time.LocalDateTime;

public class UserRoleDTO {
    private Long userRoleId;
    private Role role;
    private LocalDateTime allocatedDate;

    @Override
    public String toString() {
        return "UserRoleDTO{" +
                "userRoleId=" + userRoleId +
                ", roleType=" + role +
                ", allocatedDate=" + allocatedDate +
                '}';
    }

    public UserRoleDTO(Long userRoleId, Role role, LocalDateTime allocatedDate) {
        this.userRoleId = userRoleId;
        this.role = role;
        this.allocatedDate = allocatedDate;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getAllocatedDate() {
        return allocatedDate;
    }

    public void setAllocatedDate(LocalDateTime allocatedDate) {
        this.allocatedDate = allocatedDate;
    }
}
