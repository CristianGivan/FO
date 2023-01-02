package com.app.FO.mapper;

import com.app.FO.dto.user.UserDTO;
import com.app.FO.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserDTOMapper {
    public static UserDTOMapper INSTANCE = Mappers.getMapper(UserDTOMapper.class);
    @Mapping(target="userId", source="id")
    public abstract UserDTO UserToUserDTO(User user);
    public abstract List<UserDTO> UsersToUsersDTO(List<User> user);

}
