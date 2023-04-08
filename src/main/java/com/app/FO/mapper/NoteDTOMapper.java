package com.app.FO.mapper;

import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.note.NoteFDTO;
import com.app.FO.model.note.Note;
import com.app.FO.service.tag.TagService;
import com.app.FO.service.topic.TopicService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring",uses = {TopicDTOMapper.class,TagDTOMapper.class})
public abstract class NoteDTOMapper {
    @Autowired
    protected TagService tagService;
    @Autowired
    protected TopicService topicService;

    @Autowired
    protected TopicDTOMapper topicDTOMapper;


//    @Autowired
//    protected Remai


    //todo de ce doar daca am facut public static nu am primit err?
    //    public static NoteDTOMapper INSTANCE = Mappers.getMapper(NoteDTOMapper.class);
    @Mapping(target="noteId", source="id")
    public abstract NoteDTO NoteToNoteDTO(Note note);
    public abstract List<NoteDTO> NotesToNotesDTO(List<Note> note);
    @Mapping(target="noteId", source="id")
    @Mapping(target = "tagDTOList", expression = "java("+
            "tagService.getListOfTagsDTOByNoteId(note.getId()))")
    @Mapping(target = "topicsThatContainTheNote", expression = "java("+
            "topicDTOMapper.TopicsToTopicsDTO(topicService.getTopicsByNote(note)))")
   public abstract NoteFDTO NoteToNoteFDTO(Note note);
    public abstract List<NoteFDTO> NotesToNotesFDTO(List<Note> note);

}
