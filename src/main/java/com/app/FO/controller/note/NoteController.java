package com.app.FO.controller.note;

import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.note.NoteFDTO;
import com.app.FO.dto.general.TextDTO;
import com.app.FO.exceptions.NoteNotFoundException;
import com.app.FO.mapper.NoteDTOMapper;
import com.app.FO.model.note.Note;
import com.app.FO.service.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private NoteService noteService;
    private NoteDTOMapper noteDTOMapper;


    @Autowired
    public NoteController(NoteService noteService, NoteDTOMapper noteDTOMapper) {
        this.noteService = noteService;
        this.noteDTOMapper = noteDTOMapper;
    }


    //-- GetMapping

    //
    @GetMapping("/fromAnyUserGetNoteById/{noteId}")
    public NoteFDTO fromAnyUserGetNoteById(@PathVariable Long noteId) {
        Note note = noteService.fromAnyUserGetNoteById(noteId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }


    @GetMapping("/fromAnyUserGetAllNotes")
    public List<NoteDTO> fromAnyUserGetAllNotes() {
        List<Note> notes = noteService.fromAnyUserGetAllNotes();
        return noteDTOMapper.NotesToNotesDTO(notes);
    }


    @GetMapping("/fromAnyUserGetNotesByTagId/{tagId}")
    public List<NoteFDTO> fromAnyUserGetNotesByTagId(@PathVariable Long tagId) {
        List<Note> notes = noteService.fromAnyUserGetNotesByTagId(tagId);
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/fromAnyUserGetNotesByTopicId/{topicId}")
    public List<NoteFDTO> fromAnyUserGetNotesByTopicId(@PathVariable Long topicId) {
        List<Note> notes = noteService.fromAnyUserGetNotesByTopicId(topicId);
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/fromAnyUserGetNotesByNoteThatContainsText/{containsText}")
    public List<NoteFDTO> fromAnyUserGetNotesByNoteThatContainsText(@PathVariable String containsText) {
        List<Note> notes = noteService.fromAnyUserGetNotesByNoteThatContainsText(containsText);
        if (notes == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    //-- GetMapping From User
    @GetMapping("/fromLogInUserGetAllNotes")
    public List<NoteFDTO> fromLogInUserGetAllNotes() {
        List<Note> notes = noteService.fromLogInUserGetAllNotes();
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/fromLogInUserGetNoteByNoteId/{noteId} ")
    public NoteFDTO fromLogInUserGetNoteByNoteId(@PathVariable Long noteId) {
        Note note = noteService.fromLogInUserGetNoteByNoteId(noteId);
        if (note == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    @GetMapping("/fromLogInUserGetNotesByTagId/{tagId}")
    public List<NoteFDTO> fromLogInUserGetNotesByTagId(@PathVariable Long tagId) {
        List<Note> notes = noteService.fromLogInUserGetNotesByTagId(tagId);
        if (notes == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/fromLogInUserGetNotesByTopicId/{tagId}")
    public List<NoteFDTO> fromLogInUserGetNotesByTopicId(@PathVariable Long tagId) {
        List<Note> notes = noteService.fromLogInUserGetNotesByTopicId(tagId);
        if (notes == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/fromLogInUserGetNotesByNoteThatContainsText/{containsText}")
    public List<NoteFDTO> fromLogInUserGetNotesByNoteThatContainsText(@PathVariable String containsText) {
        List<Note> notes = noteService.fromLogInUserGetNotesByNoteThatContainsText(containsText);
        if (notes == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    //-- PostMapping

    @PostMapping("/forAnyUserPostNewNote")
    public NoteFDTO forAnyUserPostNewNote(@RequestBody TextDTO noteText) {
        Note note = noteService.forAnyUserPostNewNote(noteText.getText());
        return noteDTOMapper.NoteToNoteFDTO(note);
    }


    //-- PutMapping

    @PutMapping("/forAnyUserPutNoteText/{noteId}")
    public NoteFDTO forAnyUserPutNoteText(@PathVariable Long noteId, @RequestBody TextDTO textNote) {
        Note note = noteService.forAnyUserPutNoteText(noteId, textNote.getText());
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    @PutMapping("/forAnyUserPutTagToNote")
    public NoteFDTO forAnyUserPutTagToNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note =noteService.forAnyUserPutTagToNote(noteId, tagId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    //-- PutMapping From User

    @PutMapping("/forLogInUserPutTagToNote")
    public NoteFDTO forLogInUserPutTagToNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note = noteService.forLogInUserPutTagToNote(noteId, tagId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }


    //-- DeleteMapping

    @DeleteMapping("/forAnyUserDeleteTagFromNote")
    public NoteFDTO forAnyUserDeleteTagFromNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note =noteService.forAnyUserDeleteTagFromNote(noteId, tagId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    //--- Other


}
