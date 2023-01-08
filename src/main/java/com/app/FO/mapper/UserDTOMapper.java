package com.app.FO.mapper;

import com.app.FO.dto.user.UserDTO;
import com.app.FO.dto.user.UserFDTO;
import com.app.FO.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserRoleDTOMapper.class,UserTagDTOMapper.class})
public abstract class UserDTOMapper {

    @Mapping(target="userId", source="id")
    //@Mapping(target ="userRoles", source = "userRoles")
    public abstract UserDTO UserToUserDTO(User user);
    public abstract List<UserDTO> UsersToUsersDTO(List<User> user);
    @Mapping(target="userId", source="id")
    //@Mapping(target ="userRoles", source = "userRoles")
    public abstract UserFDTO UserToUserFDTO(User user);
    public abstract List<UserFDTO> UsersToUsersFDTO(List<User> user);
}
