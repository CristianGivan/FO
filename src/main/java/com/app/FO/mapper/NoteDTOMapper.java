package com.app.FO.mapper;

import com.app.FO.config.AllServices;
import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.note.NoteFDTO;
import com.app.FO.dto.note.NoteTDTO;
import com.app.FO.model.note.Note;
import com.app.FO.service.note.TagService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class NoteDTOMapper {
    @Autowired
    protected TagService tagService;


    //todo de ce doar daca am facut public static nu am primit err?
    //    public static NoteDTOMapper INSTANCE = Mappers.getMapper(NoteDTOMapper.class);
    @Mapping(target="noteId", source="id")
    public abstract NoteDTO NoteToNoteDTO(Note note);
    public abstract List<NoteDTO> NotesToNotesDTO(List<Note> note);
    @Mapping(target="noteId", source="id")
    @Mapping(target = "tags", expression = "java("+
            "tagService.getListOfTagsDTOByNoteId(note.getId()))")
   public abstract NoteFDTO NoteToNoteFDTO(Note note);
    public abstract List<NoteFDTO> NotesToNotesFDTO(List<Note> note);

}
