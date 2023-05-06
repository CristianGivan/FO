package com.app.FO.mapper;

import com.app.FO.dto.user.UserTagDTO;
import com.app.FO.model.tag.TagUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserTagDTOMapper {
    @Mapping(target = "useTagId", source = "id")
    @Mapping(target = "tag", expression = "java(" +
            " tagUser.getTag().getTagText())")
    @Mapping(target = "createdDate", expression = "java(" +
            "tagUser.getCreatedDate().toString())")
    public abstract UserTagDTO UserTagToUserTagDTO(TagUser tagUser);

    public abstract List<UserTagDTO> UserTagListToUserTagDTOList(List<TagUser> tagUser);

}
