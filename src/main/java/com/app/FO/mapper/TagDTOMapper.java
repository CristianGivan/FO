package com.app.FO.mapper;

import com.app.FO.dto.tag.TagSDTO;
import com.app.FO.model.tag.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagDTOMapper {
    TagDTOMapper INSTANCE = Mappers.getMapper(TagDTOMapper.class);
    @Mapping(target="tagId", source="id")
    TagSDTO tagToTagSDTO(Tag tags);

    List<TagSDTO> tagsToTagsSDTO(List<Tag> tags);
}
