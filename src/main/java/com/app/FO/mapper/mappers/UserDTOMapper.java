package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.user.UserDTO;
import com.app.FO.mapper.dto.user.UserRoleDTO;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserTagDTOMapper.class})
public abstract class UserDTOMapper {

    @Mapping(target = "userRoleId", source = "id")
    @Mapping(target = "roleType", expression = "java(" +
            "userRole.getRole().getRoleType().toString())")
    @Mapping(target = "allocatedDate", expression = "java(" +
            " userRole.getAllocatedDay().toString())")
    public abstract UserRoleDTO UserRoleToUserRoleDTO(UserRole userRole);


    public abstract List<UserRoleDTO> UserRolesToUserRolesDTO(List<UserRole> userRoleList);

    @Mapping(target = "userId", source = "id")
    //@Mapping(target ="userRoles", source = "userRoles")
    public abstract UserDTO UserToUserDTO(User user);

    public abstract List<UserDTO> UserListToUserDTOList(List<User> user);
//
//    @Mapping(target = "userId", source = "id")
//    //@Mapping(target ="userRoles", source = "userRoles")
//    public abstract UserFDTO UserToUserFDTO(User user);
//
//    public abstract List<UserFDTO> UserListToUserFDTOList(List<User> user);
}
