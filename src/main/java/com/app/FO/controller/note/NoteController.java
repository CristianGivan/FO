package com.app.FO.controller.note;

import com.app.FO.config.AllServices;
import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.note.NoteFDTO;
import com.app.FO.dto.general.TextDTO;
import com.app.FO.mapper.NoteDTOMapper;
import com.app.FO.mapper.TagDTOMapper;
import com.app.FO.mapper.UserDTOMapper;
import com.app.FO.model.note.Note;
import com.app.FO.service.note.NoteService;
import com.app.FO.service.note.TagService;
//import jdk.javadoc.internal.doclets.toolkit.taglets.TagletManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private NoteService noteService;

    //todo are sens sa fac o clasa cu toate service sa nu ma
    @Autowired
    private AllServices allServices;
    @Autowired
    private TagService tagService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    //-- GetMapping

    @GetMapping("/getNoteById/{noteId}")
    public NoteDTO getNote(@PathVariable Long noteId) {
        return NoteDTOMapper.INSTANCE.NoteToNoteDTO(noteService.getNoteById(noteId));
    }

    @GetMapping("/getAllNotes")
    public List<NoteDTO> getAllNotes() {
        return allServices.getNoteService().getAllNotesDTO();
    }

    @GetMapping("/getNotesByTagId/{tagId}")
    public List<NoteDTO> getNotesByTagId(@PathVariable Long tagId) {
        return NoteDTOMapper.INSTANCE.NotesToNotesDTO(noteService.getNotesByTagId(tagId));
    }

    @GetMapping("/getNotesByTopicId/{topicId}")
    public List<NoteDTO> getNotesByTopicId(@PathVariable Long topicId) {
        return allServices.getNoteService().getNotesDTOByTopicId(topicId);
    }

    //-- GetMapping Full
    @GetMapping("/getNoteFById/{noteId}")
    public NoteFDTO getAllNotes(@PathVariable Long noteId) {
        return convertNoteToNoteFDTO(noteService.getNoteById(noteId));
    }
    //-- PostMapping

    @PostMapping("/addNewNote")
    public NoteDTO addNewNote(@RequestBody TextDTO note) {
        return NoteDTOMapper.INSTANCE.NoteToNoteDTO(noteService.saveNote(note.getText()));
    }

    //-- PutMapping


    //-- DeleteMapping

    @DeleteMapping("/deleteTagFromNote")
    public NoteDTO deleteTagFromNote(@RequestParam Long noteId, @RequestParam Long tagId) {
        return NoteDTOMapper.INSTANCE.NoteToNoteDTO(noteService.deleteTagFromNote(noteId, tagId));
    }


    //-- Converter
    public NoteFDTO convertNoteToNoteFDTO(Note note) {
        return new NoteFDTO(note.getId(), note.getNote(), note.getCreatedDate(),
                UserDTOMapper.INSTANCE.UserToUserDTO(note.getUser()),
                allServices.getTagService().getListOfTagDTOByNoteId(note.getId())
//                ,convertListOfTopicsToListOfTopicSDTO(topicService.getTopicsByNote(note)),
//                convertListOfNoteHistoryToListOfNoteHistorySDTO(note.getNoteHistories())
        );
    }

    public List<NoteFDTO> convertListOfNotesToListOfNotesFDTO(List<Note> notes) {
        return notes.stream().map(this::convertNoteToNoteFDTO).collect(Collectors.toList());
    }


    //--- Other



    /*new features
     *
     *
     *3. add a tag to a note
     *
     * */

//    @PutMapping("/modifiesNoteText/{noteId}")
//    public NoteFDTO modifiesNoteText(@PathVariable Long noteId, @RequestBody TextDTO textNote) {
//        return converterDTO.convertNoteToNoteDTO(
//                noteService.modifiesNoteText(noteId, textNote.getText()));
//    }
////    @PutMapping("/addTagToNote/{noteId}")
////    public NoteDTO addTagToNote(@PathVariable Long noteId, @RequestBody NumberDTO tagId) {
////        return converterDTO.convertNoteToNoteDTO(
////                noteService.addTagToNote(noteId, tagId.getNumber()));
////    }
//
//    @PutMapping("/addTagToNote")
//    public NoteFDTO addTagToNote(@RequestParam Long noteId, @RequestParam Long tagId) {
//        return converterDTO.convertNoteToNoteDTO(
//                noteService.addTagToNote(noteId, tagId));
//    }


}
