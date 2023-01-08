package com.app.FO.mapper;

import com.app.FO.config.AllServices;
import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tag.TagFDTO;
import com.app.FO.model.tag.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserTagDTOMapper.class})
public abstract class TagDTOMapper {


    @Mapping(target="tagId", source="id")
    @Mapping(target="tag", source="tagName")
    public abstract TagDTO tagToTagDTO(Tag tags);

    public abstract List<TagDTO> tagsToTagsDTO(List<Tag> tags);
    @Mapping(target="tagId", source="id")
    public abstract TagFDTO tagToTagFDTO(Tag tags);
    public abstract List<TagFDTO> tagsToTagsFDTO(List<Tag> tags);


}
