package com.app.FO.mapper;

import com.app.FO.dto.note.NoteTDTO;
import com.app.FO.model.note.Note;
import com.app.FO.model.tag.Tag;
import com.app.FO.service.note.TagService;
import org.aspectj.weaver.ast.Not;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class NoteDTOMapper {
    @Autowired
    protected TagService tagService;

    //todo de ce doar daca am facut public static nu am primit err?
    public static NoteDTOMapper INSTANCE = Mappers.getMapper(NoteDTOMapper.class);
    @Mapping(target="noteId", source="id")
//    @Mapping(target = "tags", expression = "java("+
//            "tagService.getListOfTagByNoteId(note.getId()))")
//    @Mapping(target="tags", qualifiedByName = "noteTags")
   public abstract NoteTDTO NoteToNoteTDTO(Note note);

//    @Named("noteTags")
//    List<Tag> noteTags(Note note){
//        return tagService.getListOfTagByNoteId(note.getId());
//    }

}
