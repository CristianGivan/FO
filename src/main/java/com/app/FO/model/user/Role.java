package com.app.FO.model.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq",
            sequenceName = "role_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "role_id")
    @Setter(AccessLevel.NONE)
    public Long id;

    @Column(name = "role_type")
    private RoleType roleType;
    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoleList;

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

    public List<UserRole> getUserRoleList() {
        if (userRoleList ==null){
            userRoleList =new ArrayList<>();
        }
        return userRoleList;
    }
}
