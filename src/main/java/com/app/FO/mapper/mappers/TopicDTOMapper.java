package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.topic.TopicDTO;
import com.app.FO.model.topic.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class TopicDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "topicId", source = "id")
    public abstract TopicDTO TopicToTopicDTO(Topic topic);

    public abstract List<TopicDTO> TopicListToTopicDTOList(List<Topic> topic);

}
