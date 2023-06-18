package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.tag.TagDTO;
import com.app.FO.mapper.dto.tag.TagFDTO;
import com.app.FO.model.tag.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        UserDTOMapper.class, TopicDTOMapper.class})
public abstract class TagDTOMapper {

    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "tagId", source = "id")
    public abstract TagDTO tagToTagDTO(Tag tag);

    public abstract List<TagDTO> tagListToTagDTOList(List<Tag> tags);

    @Mapping(target = "tagId", source = "id")

    public abstract TagFDTO tagToTagFDTO(Tag tag);

    public abstract List<TagFDTO> tagListToTagFDTOList(List<Tag> tags);

}
