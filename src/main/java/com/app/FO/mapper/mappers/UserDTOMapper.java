package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.user.UserDTO;
import com.app.FO.mapper.dto.user.UserFDTO;
import com.app.FO.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserRoleDTOMapper.class})
public abstract class UserDTOMapper {


    @Mapping(target = "userId", source = "id")
    @Mapping(target = "userRoleDTOList", source = "userRoleList")
    public abstract UserDTO UserToUserDTO(User user);

    public abstract List<UserDTO> UserListToUserDTOList(List<User> user);

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "userRoleDTOList", source = "userRoleList")
    public abstract UserFDTO UserToUserFDTO(User user);

    public abstract List<UserFDTO> UserListToUserFDTOList(List<User> user);
}
