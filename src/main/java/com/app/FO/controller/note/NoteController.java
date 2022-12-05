package com.app.FO.controller.note;

import com.app.FO.dto.note.ShowNoteDTO;
import com.app.FO.model.note.Note;
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
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/getAllNotes")
    public List<ShowNoteDTO> getAllNotes(){
        return noteService.getAllNotes();
    }
    @GetMapping("/getNoteById/{noteId}")
    public ShowNoteDTO getAllNotes(@PathVariable Long noteId){
        return noteService.getNoteById(noteId);
    }

}
