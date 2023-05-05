package com.app.FO.controller.note;

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
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;
    private NoteDTOMapper noteDTOMapper;


    @Autowired
    public NoteController(NoteService noteService, NoteDTOMapper noteDTOMapper) {
        this.noteService = noteService;
        this.noteDTOMapper = noteDTOMapper;
    }
/*
    //-- PostMapping admin

    @PostMapping("/adminPostNewNote")
    public NoteFDTO adminPostNewNote(@RequestBody TextDTO noteText) {
        Note note = noteService.adminPostNewNote(noteText.getText());
        return noteDTOMapper.NoteToNoteFDTO(note);
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


    //-- PutMapping admin

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


    //-- DeleteMapping admin

    @DeleteMapping("/adminDeleteTagFromNote")
    public NoteFDTO adminDeleteTagFromNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note =noteService.adminDeleteTagFromNote(noteId, tagId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }
*/


    //-- PostMapping

    @PostMapping("/postNewNote")
    public NoteFDTO postNewNote(@RequestBody TextDTO noteText) {
        Note note = noteService.postNewNote(noteText.getText());
        return noteDTOMapper.NoteToNoteFDTO(note);
    }


    //-- GetMapping
    @GetMapping("/getAllNotes")
    public List<NoteFDTO> getAllNotes() {
        List<Note> notes = noteService.getNoteList();
        return noteDTOMapper.NoteListToNoteFDTOList(notes);
    }

    @GetMapping("/getNoteByNoteId/{noteId}")
    public NoteFDTO getNoteByNoteId(@PathVariable Long noteId) {
        Note note = noteService.getNoteByNoteId(noteId);
        if (note == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    @GetMapping("/getNotesByTagId/{tagId}")
    public List<NoteFDTO> getNotesByTagId(@PathVariable Long tagId) {
        List<Note> notes = noteService.getNoteListByTagId(tagId);
        return noteDTOMapper.NoteListToNoteFDTOList(notes);
    }

    @GetMapping("/getNotesByTopicId/{topicId}")
    public List<NoteFDTO> getNotesByTopicId(@PathVariable Long topicId) {
        List<Note> notes = noteService.getNoteListByTopicId(topicId);
        return noteDTOMapper.NoteListToNoteFDTOList(notes);
    }

    @GetMapping("/getNotesByNoteThatContainsText/{containsText}")
    public List<NoteFDTO> getNotesByNoteThatContainsText(@PathVariable String containsText) {
        List<Note> notes = noteService.getNoteListByNoteThatContainsText(containsText);
        return noteDTOMapper.NoteListToNoteFDTOList(notes);
    }


    //-- PutMapping

    @PutMapping("/putTagToNote")
    public NoteFDTO putTagToNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note = noteService.putTagToNote(noteId, tagId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }


    @PutMapping("/putTopicToNote")
    public NoteFDTO putTopicToNote(@RequestParam Long noteId, @RequestParam Long topicId) {
        Note note = noteService.putTopicToNote(noteId, topicId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    @PutMapping("/putRemainderToNote")
    public NoteFDTO putRemainderToNote(@RequestParam Long noteId, @RequestParam Long remainderId) {
        Note note = noteService.putRemainderToNote(noteId, remainderId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    @PutMapping("/putUserToNote")
    public NoteFDTO putUserToNote(@RequestParam Long noteId, @RequestParam Long userId) {
        Note note = noteService.putUserToNote(noteId, userId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }


    //-- DeleteMapping
    @DeleteMapping("/deleteNoteByNoteId")
    public NoteFDTO deleteNoteByNoteId(@RequestParam Long noteId) {
        Note note = noteService.deleteNoteByNoteId(noteId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    @DeleteMapping("/deleteTagFromNote")
    public NoteFDTO deleteTagFromNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note = noteService.deleteTagFromNote(noteId, tagId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    @DeleteMapping("/deleteTopicFromNote")
    public NoteFDTO deleteTopicFromNote(@RequestParam Long noteId, @RequestParam Long topicId) {
        Note note = noteService.deleteTopicFromNote(noteId, topicId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    @DeleteMapping("/deleteRemainderFromNote")
    public NoteFDTO deleteRemainderFromNote(@RequestParam Long noteId, @RequestParam Long remainderId) {
        Note note = noteService.deleteRemainderFromNote(noteId, remainderId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    @DeleteMapping("/deleteUserFromNote")
    public NoteFDTO deleteUserFromNote(@RequestParam Long noteId, @RequestParam Long userId) {
        Note note = noteService.deleteUserFromNote(noteId, userId);
        return noteDTOMapper.NoteToNoteFDTO(note);
    }

    //--- Other


}
