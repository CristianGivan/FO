package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.user.UserRoleDTO;
import com.app.FO.model.user.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserRoleDTOMapper {


    @Mapping(target = "userRoleId", source = "id")
    @Mapping(target = "roleType", expression = "java(" +
            "userRole.getRole().getRoleType().toString())")
    @Mapping(target = "allocatedDate", expression = "java(" +
            " userRole.getAllocatedDay().toString())")
    public abstract UserRoleDTO UserRoleToUserRoleDTO(UserRole userRole);

    public abstract List<UserRoleDTO> UserRolesToUserRolesDTO(List<UserRole> userRole);
}
