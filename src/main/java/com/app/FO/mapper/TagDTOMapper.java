package com.app.FO.mapper;

import com.app.FO.dto.tag.TagFDTO;
import com.app.FO.dto.tag.TagDTO;
import com.app.FO.model.tag.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagDTOMapper {
    TagDTOMapper INSTANCE = Mappers.getMapper(TagDTOMapper.class);
    @Mapping(target="tagId", source="id")
    TagDTO tagToTagDTO(Tag tags);

    List<TagDTO> tagsToTagsDTO(List<Tag> tags);
}
