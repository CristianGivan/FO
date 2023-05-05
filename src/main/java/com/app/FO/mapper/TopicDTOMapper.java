package com.app.FO.mapper;

import com.app.FO.dto.topic.TopicDTO;
import com.app.FO.model.topic.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TopicDTOMapper {

    @Mapping(target = "topicId", source = "id")
    public abstract TopicDTO TopicToTopicDTO(Topic topic);

    public abstract List<TopicDTO> TopicListToTopicDTOList(List<Topic> topic);

}
