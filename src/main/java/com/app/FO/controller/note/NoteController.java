package com.app.FO.controller.note;

import com.app.FO.dto.ConvertToDTO;
import com.app.FO.dto.note.NoteDTO;
import com.app.FO.service.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private NoteService noteService;
    @Autowired
    private ConvertToDTO convertToDTO;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/getAllNotes")
    public List<NoteDTO> getAllNotes(){
        return convertToDTO.convertListOfNoteToListOfNoteDTO(noteService.getAllNotes());
    }
    @GetMapping("/getNoteById/{noteId}")
    public NoteDTO getAllNotes(@PathVariable Long noteId){
        return convertToDTO.convertNoteToNoteDTO(noteService.getNoteById(noteId));
    }

}
