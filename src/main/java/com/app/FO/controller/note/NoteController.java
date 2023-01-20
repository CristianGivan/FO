package com.app.FO.controller.note;

import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.note.NoteFDTO;
import com.app.FO.dto.general.TextDTO;
import com.app.FO.exceptions.NoteNotFoundException;
import com.app.FO.service.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    //-- GetMapping

    //
    @GetMapping("/getNoteById/{noteId}")
    public NoteDTO getNote(@PathVariable Long noteId) {
        return noteService.getNoteDTOByNoteId(noteId);
    }

    @GetMapping("/getNoteFById/{noteId}")
    public NoteFDTO getNoteFull(@PathVariable Long noteId) {
        return noteService.getNoteFDTOByNoteId(noteId);
    }

    @GetMapping("/getAllNotes")
    public List<NoteDTO> getAllNotes() {
        return noteService.getAllNotesDTO();
    }


    @GetMapping("/getNotesByTagId/{tagId}")
    public List<NoteDTO> getNotesByTagId(@PathVariable Long tagId) {
        return noteService.getNotesDTOByTagId(tagId);
    }

    @GetMapping("/getNotesByTopicId/{topicId}")
    public List<NoteDTO> getNotesByTopicId(@PathVariable Long topicId) {
        return noteService.getNotesDTOByTopicId(topicId);
    }

    @GetMapping("/getNotesDTOByNoteContainsText/{containsText}")
    public List<NoteDTO> getNotesDTOByNoteContainsText(@PathVariable String containsText) {
        List<NoteDTO> foundNotes =noteService.getNotesDTOByNoteContainsText(containsText);
        if (foundNotes==null){
            throw new NoteNotFoundException("The note was not found");
        }
        return foundNotes;
    }

    //-- GetMapping From User
    @GetMapping("/getAllNotesFromLogInUser")
    public List<NoteDTO> getAllNotesFromLogInUser() {
        return noteService.getAllNotesDTOFromLogInUser();
    }

    @GetMapping("/getNoteFDTOFromLogInUserById/{noteId} ")
    public NoteFDTO getNoteFDTOFromLogInUserById(@PathVariable Long noteId) {
        NoteFDTO foundNote =noteService.getNoteFDTOFromLogInUserByNoteId(noteId);
        if (foundNote==null){
            throw new NoteNotFoundException("The note was not found");
        }
        return foundNote;
    }

    @GetMapping("/getNotesFDTOFromLogInUserByTagId/{tagId}")
    public List<NoteFDTO> getNotesFDTOFromLogInUserByTagId(@PathVariable Long tagId) {
        List<NoteFDTO> foundNotes = noteService.getNotesFDTOFromLogInUserByTagId(tagId);
        if (foundNotes==null){
            throw new NoteNotFoundException("The note was not found");
        }
        return foundNotes;
    }
    @GetMapping("/getNotesFDTOFromLogInUserByTopicId/{tagId}")
    public List<NoteFDTO> getNotesFDTOFromLogInUserByTopicId(@PathVariable Long tagId) {
        List<NoteFDTO> foundNotes =  noteService.getNotesFDTOFromLogInUserByTopicId(tagId);;
        if (foundNotes==null){
            throw new NoteNotFoundException("The note was not found");
        }
       return foundNotes;
    }
    @GetMapping("/getNotesDTOFromLogInUserByNoteContainsText/{containsText}")
    public List<NoteDTO> getNotesDTOFromLogInUserIdByNoteContainsText(@PathVariable String containsText) {
        List<NoteDTO> foundNotes =noteService.getNotesDTOFromLogInUserIdByNoteContainsText(containsText);
        if (foundNotes==null){
            throw new NoteNotFoundException("The note was not found");
        }
        return foundNotes;
    }

    //-- PostMapping

    @PostMapping("/addNewNote")
    public NoteDTO addNewNote(@RequestBody TextDTO note) {
        return noteService.saveNoteDTO(note.getText());
    }

    //-- PutMapping

    @PutMapping("/modifiesNoteText/{noteId}")
    public NoteFDTO modifiesNoteText(@PathVariable Long noteId, @RequestBody TextDTO textNote) {
        return noteService.modifiesNoteFDTOText(noteId, textNote.getText());
    }

    @PutMapping("/addTagToNote")
    public NoteFDTO addTagToNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        return noteService.addTagToNoteFDTO(noteId, tagId);
    }

    //-- DeleteMapping

    @DeleteMapping("/deleteTagFromNote")
    public NoteFDTO deleteTagFromNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        return noteService.deleteTagFromNoteFDTO(noteId, tagId);
    }

    //--- Other


}
