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
    @GetMapping("/getNoteById/{noteId}")
    public NoteFDTO getNote(@PathVariable Long noteId) {
        Note note = noteService.getNoteByNoteId(noteId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }


    @GetMapping("/getAllNotes")
    public List<NoteDTO> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return noteDTOMapper.NotesToNotesDTO(notes);
    }


    @GetMapping("/getNotesByTagId/{tagId}")
    public List<NoteFDTO> getNotesByTagId(@PathVariable Long tagId) {
        List<Note> notes = noteService.getNotesByTagId(tagId);
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/getNotesByTopicId/{topicId}")
    public List<NoteFDTO> getNotesByTopicId(@PathVariable Long topicId) {
        List<Note> notes = noteService.getNotesByTopicId(topicId);
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/getNotesByNoteContainsText/{containsText}")
    public List<NoteFDTO> getNotesDTOByNoteContainsText(@PathVariable String containsText) {
        List<Note> notes = noteService.getNotesByNoteContainsText(containsText);
        if (notes == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    //-- GetMapping From User
    @GetMapping("/getAllNotesFromLogInUser")
    public List<NoteFDTO> getAllNotesFromLogInUser() {
        List<Note> notes = noteService.getAllNotesFromLogInUser();
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/getNoteFromLogInUserByNoteId/{noteId} ")
    public NoteFDTO getNoteFromLogInUserByNoteId(@PathVariable Long noteId) {
        Note note = noteService.getNoteFromLogInUserByNoteId(noteId);
        if (note == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    @GetMapping("/getNotesFromLogInUserByTagId/{tagId}")
    public List<NoteFDTO> getNotesFromLogInUserByTagId(@PathVariable Long tagId) {
        List<Note> notes = noteService.getNotesFromLogInUserByTagId(tagId);
        if (notes == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/getNotesFromLogInUserByTopicId/{tagId}")
    public List<NoteFDTO> getNotesFromLogInUserByTopicId(@PathVariable Long tagId) {
        List<Note> notes = noteService.getNotesFromLogInUserByTopicId(tagId);
        if (notes == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    @GetMapping("/fromLogInUserGetNotesByNoteContainsText/{containsText}")
    public List<NoteFDTO> getNotesFromLogInUserByNoteContainsText(@PathVariable String containsText) {
        List<Note> notes = noteService.getNotesFromLogInUserByNoteContainsText(containsText);
        if (notes == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NotesToNotesFDTO(notes);
    }

    //-- PostMapping

    @PostMapping("/addNewNote")
    public NoteFDTO addNewNote(@RequestBody TextDTO noteText) {
        Note note = noteService.addNote(noteText.getText());
        return noteDTOMapper.NoteToNoteFDTO(note);
    }


    //-- PutMapping

    @PutMapping("/modifyNoteText/{noteId}")
    public NoteFDTO modifyNoteText(@PathVariable Long noteId, @RequestBody TextDTO textNote) {
        Note note = noteService.modifyNoteText(noteId, textNote.getText());
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    @PutMapping("/addTagToNote")
    public NoteFDTO addTagToNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note =noteService.addTagToNote(noteId, tagId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    //-- GetMapping From User

    @PutMapping("/forLogInUserAddTagToNote")
    public NoteFDTO forLogInUserAddTagToNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note = noteService.forLogInUserAddTagToNote(noteId, tagId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }


    //-- DeleteMapping

    @DeleteMapping("/deleteTagFromNote")
    public NoteFDTO deleteTagFromNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note =noteService.deleteTagFromNote(noteId, tagId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    //--- Other


}
