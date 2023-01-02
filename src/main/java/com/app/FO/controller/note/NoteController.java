package com.app.FO.controller.note;

import com.app.FO.dto.ConverterDTO;
import com.app.FO.dto.note.NoteFDTO;
import com.app.FO.dto.general.TextDTO;
import com.app.FO.service.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<NoteFDTO> getAllNotes() {
        return converterDTO.convertListOfNoteToListOfNoteDTO(noteService.getAllNotes());
    }

    @GetMapping("/getNoteById/{noteId}")
    public NoteFDTO getAllNotes(@PathVariable Long noteId) {
        return converterDTO.convertNoteToNoteDTO(noteService.getNoteById(noteId));
    }

    @GetMapping("/getNotesByTagId/{tagId}")
    public List<NoteFDTO> getNotesByTagId(@PathVariable Long tagId) {
        return converterDTO.convertListOfNoteToListOfNoteDTO(
                noteService.getNotesByTagId(tagId));
    }

    @GetMapping("/getNotesByTopicId/{topicId}")
    public List<NoteFDTO> getNotesByTopicId(@PathVariable Long topicId) {
        return converterDTO.convertListOfNoteToListOfNoteDTO(
                noteService.getNotesByTopicId(topicId));
    }

    @PostMapping("/addNewNote")
    public NoteFDTO addNewNote(@RequestBody TextDTO note) {
        return converterDTO.convertNoteToNoteDTO(
                noteService.saveNote(note.getText()));
    }
    /*new features
     *
     *
     *3. add a tag to a note
     *
     * */

    @PutMapping("/modifiesNoteText/{noteId}")
    public NoteFDTO modifiesNoteText(@PathVariable Long noteId, @RequestBody TextDTO textNote) {
        return converterDTO.convertNoteToNoteDTO(
                noteService.modifiesNoteText(noteId, textNote.getText()));
    }
//    @PutMapping("/addTagToNote/{noteId}")
//    public NoteDTO addTagToNote(@PathVariable Long noteId, @RequestBody NumberDTO tagId) {
//        return converterDTO.convertNoteToNoteDTO(
//                noteService.addTagToNote(noteId, tagId.getNumber()));
//    }

    @PutMapping("/addTagToNote")
    public NoteFDTO addTagToNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        return converterDTO.convertNoteToNoteDTO(
                noteService.addTagToNote(noteId, tagId));
    }

    @DeleteMapping("/deleteTagFromNote")
    public NoteFDTO deleteTagFromNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        return converterDTO.convertNoteToNoteDTO(
                noteService.deleteTagFromNote(noteId, tagId));
    }

}
