package com.app.FO.mapper.mappers;

import com.app.FO.config.AllServices;
import com.app.FO.mapper.dto.user.UserDTO;
import com.app.FO.mapper.dto.user.UserFDTO;
import com.app.FO.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TagDTOMapper.class, UserRoleDTOMapper.class})
public abstract class UserDTOMapper {
    @Autowired
    protected AllServices allServices;

//    @Autowired
//    protected TagDTOMapper tagDTOMapper;

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "userRoleDTOList", source = "userRoleList")
    public abstract UserDTO UserToUserDTO(User user);

    public abstract List<UserDTO> UserListToUserDTOList(List<User> user);

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "userRoleDTOList", source = "userRoleList")
    @Mapping(target = "userDTOList", expression = "java(" +
            "UserListToUserDTOList(allServices.getUserListDTOByUser(user))" +
            ")")
//    @Mapping(target = "tagDTOList", expression = "java(" +
//            "tagDTOMapper.tagListToTagDTOList(allServices.getTagListDTOByUser(user))" +
//            ")")
    public abstract UserFDTO UserToUserFDTO(User user);

    public abstract List<UserFDTO> UserListToUserFDTOList(List<User> user);
}
