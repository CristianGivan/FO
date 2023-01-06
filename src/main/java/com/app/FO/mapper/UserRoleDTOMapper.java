package com.app.FO.mapper;

import com.app.FO.config.DateTime;
import com.app.FO.dto.user.UserRoleDTO;
import com.app.FO.model.user.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring",uses = {DateTime.class})
public abstract class UserRoleDTOMapper {
    @Autowired
    protected DateTime dateTime;

    @Mapping(target = "userRoleId", source = "id")
    @Mapping(target = "roleType", expression = "java(" +
            "userRole.getRole().getRoleType().toString())")
    @Mapping(target = "allocatedDate", expression = "java(" +
            " dateTime.dataTimeToString(userRole.getAllocatedDay()))")
    public abstract UserRoleDTO UserRoleToUserRoleDTO(UserRole userRole);

    public abstract List<UserRoleDTO> UserRolesToUserRolesDTO(List<UserRole> userRole);
}
