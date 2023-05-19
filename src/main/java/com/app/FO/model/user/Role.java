package com.app.FO.model.user;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq",
            sequenceName = "role_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_type")
    private RoleType roleType;

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoleList;

    public Role() {
    }

    public Role(RoleType roleType) {
        this.roleType = roleType;
    }

    public Role(RoleType roleType, List<UserRole> userRoleList) {
        this.roleType = roleType;
        this.userRoleList = userRoleList;

    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleType=" + roleType +
                ", userRoles=" + userRoleList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public List<UserRole> getUserRoleList() {
        if (userRoleList == null) {
            userRoleList = new ArrayList<>();
        }
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoles) {
        this.userRoleList = userRoles;
    }
}
