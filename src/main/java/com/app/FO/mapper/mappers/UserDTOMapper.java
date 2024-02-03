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
    public abstract UserDTO userToUserDTO(User user);

    public abstract List<UserDTO> userListToUserDTOList(List<User> user);

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "userRoleDTOList", source = "userRoleList")
    @Mapping(target = "userDTOList", expression = "java(" +
            "userListToUserDTOList(allServices.getUserListDTOByUser(user))" +
            ")")
//    @Mapping(target = "tagDTOList", expression = "java(" +
//            "tagDTOMapper.tagListToTagDTOList(allServices.getTagListDTOByUser(user))" +
//            ")")
    public abstract UserFDTO userToUserFDTO(User user);

    public abstract List<UserFDTO> userListToUserFDTOList(List<User> user);
}
