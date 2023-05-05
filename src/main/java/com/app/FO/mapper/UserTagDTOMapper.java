package com.app.FO.mapper;

import com.app.FO.dto.user.UserTagDTO;
import com.app.FO.model.user.UserTag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserTagDTOMapper {
    @Mapping(target = "useTagId", source = "id")
    @Mapping(target = "tag", expression = "java(" +
            " userTag.getTag().getTagName())")
    @Mapping(target = "createdDate", expression = "java(" +
            "userTag.getCreatedDate().toString())")
    public abstract UserTagDTO UserTagToUserTagDTO(UserTag userTag);

    public abstract List<UserTagDTO> UserTagListToUserTagDTOList(List<UserTag> userTag);

}
