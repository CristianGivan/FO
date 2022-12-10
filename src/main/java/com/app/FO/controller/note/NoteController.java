package com.app.FO.controller.note;

import com.app.FO.dto.ConverterDTO;
import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.note.NoteSDTO;
import com.app.FO.dto.note.TextDTO;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.NoteHistory;
import com.app.FO.model.user.User;
import com.app.FO.service.note.NoteService;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/notes")
public class NoteController {
    private NoteService noteService;
    @Autowired
    private ConverterDTO converterDTO;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/getAllNotes")
    public List<NoteDTO> getAllNotes() {
        return converterDTO.convertListOfNoteToListOfNoteDTO(noteService.getAllNotes());
    }

    @GetMapping("/getNoteById/{noteId}")
    public NoteDTO getAllNotes(@PathVariable Long noteId) {
        return converterDTO.convertNoteToNoteDTO(noteService.getNoteById(noteId));
    }

    @GetMapping("/getNotesByTagId/{tagId}")
    public List<NoteDTO> getNotesByTagId(@PathVariable Long tagId) {
        return converterDTO.convertListOfNoteToListOfNoteDTO(
                noteService.getNotesByTagId(tagId));
    }

    @GetMapping("/getNotesByTopicId/{topicId}")
    public List<NoteDTO> getNotesByTopicId(@PathVariable Long topicId) {
        return converterDTO.convertListOfNoteToListOfNoteDTO(
                noteService.getNotesByTopicId(topicId));
    }

    @PostMapping("/addNewNote")
    public NoteDTO addNewNote(@RequestBody TextDTO note) {
        return converterDTO.convertNoteToNoteDTO(
                noteService.saveNote(note.getText()));
    }
    /*new features
     *1. update a note
     *2. save a note in history aftere an update
     *3. add a tag to a note
     *
     * */

    /*
    * testez daca schim useru se salvaza in history
    * */
    @PutMapping("/modifiesNoteText/{noteId}")
    public NoteDTO modifiesNoteText(@PathVariable Long noteId, @RequestBody TextDTO textNote) {
//        Note foundNote = noteService.getNoteById(noteId);
//        NoteHistory noteHistory = noteService.createNoteHistory(foundNote);
//        //foundNote.setUser(UserService.getActualUser());
//        foundNote.setNote(textNote.getText());
//        foundNote.getNoteHistories().add(noteHistory);
//        return converterDTO.convertNoteToNoteDTO(
//                noteService.saveNote(foundNote));
        return converterDTO.convertNoteToNoteDTO(
                noteService.modifiesNoteText(noteId, textNote.getText()));
    }
}
