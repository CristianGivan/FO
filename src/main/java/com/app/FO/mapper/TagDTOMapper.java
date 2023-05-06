package com.app.FO.mapper;

import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tag.TagFDTO;
import com.app.FO.model.tag.Tag;
import com.app.FO.service.note.NoteService;
import com.app.FO.service.topic.TopicService;
import com.app.FO.service.user.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserTagDTOMapper.class,UserDTOMapper.class,TopicDTOMapper.class})
public abstract class TagDTOMapper {
    @Autowired
    protected UserService userService;
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Autowired
    protected TopicService topicService;
    @Autowired
    protected TopicDTOMapper topicDTOMapper;

    //todo spring.main.allow-circular-references if I uncomment note service
//    @Autowired
//    protected NoteService noteService;
//    @Autowired
//    protected NoteDTOMapper noteDTOMapper;

    @Mapping(target="tagId", source="id")
    public abstract TagDTO tagToTagDTO(Tag tags);

    public abstract List<TagDTO> tagListToTagDTOList(List<Tag> tags);
    @Mapping(target="tagId", source="id")
    @Mapping(target = "userDTOList", expression = "java("+
            "userDTOMapper.UserListToUserDTOList(userService.getUserListByTagId(tagId))" +
            ")")
//    @Mapping(target = "noteDTOList", expression = "java("+
//            "" +
//            ")")
    @Mapping(target = "topicDTOList", expression = "java("+
            "topicDTOMapper.TopicListToTopicDTOList(topicService.getTopicsByTagId(tagId))" +
            ")")
    public abstract TagFDTO tagToTagFDTO(Tag tags);

    public abstract List<TagFDTO> tagListToTagFDTOList(List<Tag> tags);


}
