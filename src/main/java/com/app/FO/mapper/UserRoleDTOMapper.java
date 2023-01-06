package com.app.FO.mapper;

import com.app.FO.dto.user.UserRoleDTO;
import com.app.FO.model.user.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserRoleDTOMapper {

    @Mapping(target = "userRoleId", source = "id")
//    @Mapping(target="roleType", source="role")
    @Mapping(target = "roleType", expression = "java(" +
            "userRole.getRole().getRoleType().toString())")

    public abstract UserRoleDTO UserRoleToUserRoleDTO(UserRole userRole);

    public abstract List<UserRoleDTO> UserRolesToUserRolesDTO(List<UserRole> userRole);
}
