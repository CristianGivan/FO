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


    //-- GetMapping admin

    //
    @GetMapping("/adminGetNoteById/{noteId}")
    public NoteFDTO adminGetNoteById(@PathVariable Long noteId) {
        Note note = noteService.adminGetNoteById(noteId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }


    @GetMapping("/adminGetAllNotes")
    public List<NoteDTO> adminGetAllNotes() {
        List<Note> notes = noteService.adminGetAllNotes();
        return noteDTOMapper.NotesToNotesDTO(notes);
    }


    @GetMapping("/adminGetNotesByTagId/{tagId}")
    public List<NoteFDTO> adminGetNotesByTagId(@PathVariable Long tagId) {
        List<Note> notes = noteService.adminGetNotesByTagId(tagId);
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/adminGetNotesByTopicId/{topicId}")
    public List<NoteFDTO> adminGetNotesByTopicId(@PathVariable Long topicId) {
        List<Note> notes = noteService.adminGetNotesByTopicId(topicId);
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/adminGetNotesByNoteThatContainsText/{containsText}")
    public List<NoteFDTO> adminGetNotesByNoteThatContainsText(@PathVariable String containsText) {
        List<Note> notes = noteService.adminGetNotesByNoteThatContainsText(containsText);
        if (notes == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    //-- GetMapping
    @GetMapping("/getAllNotes")
    public List<NoteFDTO> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/getNoteByNoteId/{noteId} ")
    public NoteFDTO getNoteByNoteId(@PathVariable Long noteId) {
        Note note = noteService.getNoteByNoteId(noteId);
        if (note == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    @GetMapping("/getNotesByTagId/{tagId}")
    public List<NoteFDTO> getNotesByTagId(@PathVariable Long tagId) {
        List<Note> notes = noteService.getNotesByTagId(tagId);
        if (notes == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/getNotesByTopicId/{tagId}")
    public List<NoteFDTO> getNotesByTopicId(@PathVariable Long tagId) {
        List<Note> notes = noteService.getNotesByTopicId(tagId);
        if (notes == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/getNotesByNoteThatContainsText/{containsText}")
    public List<NoteFDTO> getNotesByNoteThatContainsText(@PathVariable String containsText) {
        List<Note> notes = noteService.getNotesByNoteThatContainsText(containsText);
        if (notes == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    //-- PostMapping

    @PostMapping("/adminPostNewNote")
    public NoteFDTO adminPostNewNote(@RequestBody TextDTO noteText) {
        Note note = noteService.adminPostNewNote(noteText.getText());
        return noteDTOMapper.NoteToNoteFDTO(note);
    }


    //-- PutMapping

    @PutMapping("/adminPutNoteText/{noteId}")
    public NoteFDTO adminPutNoteText(@PathVariable Long noteId, @RequestBody TextDTO textNote) {
        Note note = noteService.adminPutNoteText(noteId, textNote.getText());
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    @PutMapping("/adminPutTagToNote")
    public NoteFDTO adminPutTagToNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note =noteService.adminPutTagToNote(noteId, tagId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    //-- PutMapping From User

    @PutMapping("/putTagToNote")
    public NoteFDTO UserPutTagToNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note = noteService.forLogInUserPutTagToNote(noteId, tagId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }


    //-- DeleteMapping

    @DeleteMapping("/adminDeleteTagFromNote")
    public NoteFDTO adminDeleteTagFromNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note =noteService.adminDeleteTagFromNote(noteId, tagId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    //--- Other


}
