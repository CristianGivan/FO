package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.note.NoteDTO;
import com.app.FO.mapper.dto.note.NoteFDTO;
import com.app.FO.model.note.Note;
import com.app.FO.service.reminder.ReminderService;
import com.app.FO.service.tag.TagService;
import com.app.FO.service.topic.TopicService;
import com.app.FO.service.user.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class, TagDTOMapper.class, ReminderDTOMapper.class, TopicDTOMapper.class})
public abstract class NoteDTOMapper {
    @Autowired
    protected TagService tagService;
    @Autowired
    protected TagDTOMapper tagDTOMapper;
    @Autowired
    protected UserService userService;
    @Autowired
    protected UserDTOMapper userDTOMapper;
    @Autowired
    protected TopicService topicService;

    @Autowired
    protected TopicDTOMapper topicDTOMapper;

    @Autowired
    protected ReminderService reminderService;
    @Autowired
    protected ReminderDTOMapper reminderDTOMapper;

    //todo de ce doar daca am facut public static nu am primit err?
    //    public static NoteDTOMapper INSTANCE = Mappers.getMapper(NoteDTOMapper.class);
    @Mapping(target = "noteId", source = "id")
    public abstract NoteDTO noteToNoteDTO(Note note);

    public abstract List<NoteDTO> noteListToNoteDTOList(List<Note> note);

    @Mapping(target = "noteId", source = "id")
    @Mapping(target = "userDTOList", expression = "java(" +
            "userDTOMapper.userListToUserDTOList(userService.getUserListByNoteId(noteId))" +
            ")")
    @Mapping(target = "tagDTOList", expression = "java(" +
            "tagDTOMapper.tagListToTagDTOList(tagService.getListOfTagByNoteId(noteId))" +
            ")")
    @Mapping(target = "remainderDTOList", expression = "java(" +
            "reminderDTOMapper.reminderListTOReminderDTOList(reminderService.getReminderListByNoteId(noteId))" +
            ")")
//    @Mapping(target = "topicDTOList", expression = "java(" +
//            "topicDTOMapper.TopicListToTopicDTOList(topicService.getTopicsByNote(noteId))" +
//            ")")
    public abstract NoteFDTO noteToNoteFDTO(Note note);

    public abstract List<NoteFDTO> noteListToNoteFDTOList(List<Note> note);
}
