package com.app.FO.mapper;

import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.note.NoteTDTO;
import com.app.FO.model.note.Note;
import com.app.FO.service.note.TagService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class NoteDTOMapper {
    @Autowired
    public TagService tagService;

    //todo de ce doar daca am facut public static nu am primit err?
    public static NoteDTOMapper INSTANCE = Mappers.getMapper(NoteDTOMapper.class);
    @Mapping(target="noteId", source="id")
//    @Mapping(target = "tags", expression = "java("+
//            "tagService.getListOfTagByNoteId(note.getId()))")
//    @Mapping(target="tags", qualifiedByName = "noteTags")
//    public abstract NoteTDTO NoteToNoteTDTO(Note note);
   public abstract NoteDTO NoteToNoteSDTO(Note note);

    public NoteTDTO NoteToNoteTDTO(Note note){
     return new NoteTDTO(note.getId(),note.getNote());
//     return new NoteTDTO(note.getId(),note.getNote(),tagService.getListOfTagByNoteId(note.getId()));
    }

//    @Named("noteTags")
//    List<Tag> noteTags(Note note){
//        return tagService.getListOfTagByNoteId(note.getId());
//    }

}
