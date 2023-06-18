package com.app.FO.controller;

import com.app.FO.exceptions.NoteNotFoundException;
import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.note.NoteDTO;
import com.app.FO.mapper.dto.note.NoteFDTO;
import com.app.FO.mapper.mappers.NoteDTOMapper;
import com.app.FO.model.note.Note;
import com.app.FO.service.note.NoteService;
import io.swagger.annotations.ApiOperation;
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


    //-- PostMapping

    @PostMapping("/postNote")
    public NoteFDTO postNote(@RequestBody TextDTO noteText) {
        Note note = noteService.postNote(noteText.getText());
        return noteDTOMapper.noteToNoteFDTO(note);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToNote")
    public NoteDTO putSubjectToNote(@RequestParam Long noteId, @RequestParam String subject) {
        Note note = noteService.putSubjectToNote(noteId, subject);
        return noteDTOMapper.noteToNoteDTO(note);
    }

    @PutMapping("/putTypeToNote")
    public NoteDTO putTypeToNote(@RequestParam Long noteId, @RequestParam String type) {
        Note note = noteService.putTypeToNote(noteId, type);
        return noteDTOMapper.noteToNoteDTO(note);
    }


    @PutMapping("/putTagToNote")
    public NoteFDTO putTagToNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note = noteService.putTagToNote(noteId, tagId);
        return noteDTOMapper.noteToNoteFDTO(note);
    }

    @PutMapping("/putUserToNote")
    public NoteFDTO putUserToNote(@RequestParam Long noteId, @RequestParam Long userId) {
        Note note = noteService.putUserToNote(noteId, userId);
        return noteDTOMapper.noteToNoteFDTO(note);
    }


    @PutMapping("/putReminderToNote")
    public NoteFDTO putReminderToNote(@RequestParam Long noteId, @RequestParam Long ReminderId) {
        Note note = noteService.putReminderToNote(noteId, ReminderId);
        return noteDTOMapper.noteToNoteFDTO(note);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteTagFromNote")
    public NoteFDTO deleteTagFromNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        Note note = noteService.deleteTagFromNote(noteId, tagId);
        return noteDTOMapper.noteToNoteFDTO(note);
    }


    @DeleteMapping("/deleteReminderFromNote")
    public NoteFDTO deleteReminderFromNote(@RequestParam Long noteId, @RequestParam Long ReminderId) {
        Note note = noteService.deleteReminderFromNote(noteId, ReminderId);
        return noteDTOMapper.noteToNoteFDTO(note);
    }

    @DeleteMapping("/deleteUserFromNote")
    public NoteFDTO deleteUserFromNote(@RequestParam Long noteId, @RequestParam Long userId) {
        Note note = noteService.deleteUserFromNote(noteId, userId);
        return noteDTOMapper.noteToNoteFDTO(note);
    }

    @DeleteMapping("/deleteNote")
    public List<NoteDTO> deleteNote(@RequestParam Long noteId) {
        List<Note> noteList = noteService.deleteNote(noteId);
        return noteDTOMapper.noteListToNoteDTOList(noteList);
    }

    //-- GetMapping
    @GetMapping("/getAllNote")
    public List<NoteDTO> getAllNote() {
        List<Note> notes = noteService.getAllNote();
        return noteDTOMapper.noteListToNoteDTOList(notes);
    }

    @GetMapping("/getNoteByNoteId/{noteId}")
    public NoteDTO getNoteByNoteId(@PathVariable Long noteId) {
        Note note = noteService.getNoteByNoteId(noteId);
        if (note == null) {
            throw new NoteNotFoundException("The note was not found");
        }
        return noteDTOMapper.noteToNoteDTO(note);
    }

    @GetMapping("/getNoteBySubject")
    public NoteDTO getNoteBySubject(@RequestParam String subject) {
        Note note = noteService.getNoteBySubject(subject);
        return noteDTOMapper.noteToNoteDTO(note);
    }

    @GetMapping("/getNoteListBySubjectContains")
    public List<NoteDTO> getNoteListBySubjectContains(@RequestParam String subjectContain) {
        List<Note> noteList = noteService.getNoteListBySubjectContains(subjectContain);
        return noteDTOMapper.noteListToNoteDTOList(noteList);
    }

    @GetMapping("/getNoteByType")
    public NoteDTO getNoteByType(@RequestParam String type) {
        Note note = noteService.getNoteByType(type);
        return noteDTOMapper.noteToNoteDTO(note);
    }

    @GetMapping("/getNoteByTypeContains")
    public List<NoteDTO> getNoteByTypeContains(@RequestParam String typeContain) {
        List<Note> noteList = noteService.getNoteByTypeContains(typeContain);
        return noteDTOMapper.noteListToNoteDTOList(noteList);
    }


    @GetMapping("/getNoteByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public NoteDTO getNoteByCreatedDate(@RequestParam String createdDate) {
        Note note = noteService.getNoteByCreatedDate(createdDate);
        return noteDTOMapper.noteToNoteDTO(note);
    }

    @GetMapping("/getNoteListByCreatedDateBetween")
    public List<NoteDTO> getNoteListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Note> noteList = noteService.getNoteListByCreatedDateBetween(createdDateMin, createdDateMax);
        return noteDTOMapper.noteListToNoteDTOList(noteList);
    }

    @GetMapping("/getNoteListByUserId")
    public List<NoteDTO> getNoteListByUserId(@RequestParam Long userId) {
        List<Note> noteList = noteService.getNoteListByUserId(userId);
        return noteDTOMapper.noteListToNoteDTOList(noteList);
    }

    @GetMapping("/getNoteListByTagId/{tagId}")
    public List<NoteFDTO> getNoteListByTagId(@PathVariable Long tagId) {
        List<Note> notes = noteService.getNoteListByTagId(tagId);
        return noteDTOMapper.noteListToNoteFDTOList(notes);
    }

    @GetMapping("/getNoteListByReminderId")
    public List<NoteDTO> getNoteListByReminderId(@RequestParam Long reminderId) {
        List<Note> noteList = noteService.getNoteListByReminderId(reminderId);
        return noteDTOMapper.noteListToNoteDTOList(noteList);
    }


    //--- Other


}
