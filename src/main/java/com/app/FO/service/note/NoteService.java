package com.app.FO.service.note;

import com.app.FO.config.AllServices;
import com.app.FO.dto.note.NoteDTO;
import com.app.FO.exceptions.NoteNotFoundException;
import com.app.FO.exceptions.TagAlreadyExistException;
import com.app.FO.mapper.NoteDTOMapper;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.NoteHistory;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.user.User;
import com.app.FO.repository.note.NoteRepository;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {
    private NoteRepository noteRepository;
    private UserService userService;

    @Autowired
    private TagService tagService;
    @Autowired
    private NoteTagService noteTagService;

    @Autowired
    public NoteService(NoteRepository noteRepository,UserService userService) {
        this.noteRepository = noteRepository;
        this.userService=userService;
    }

    //-- GET


    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
    public List<Note> getNotesByTopicId(Long topicId) {
        return noteRepository.getNotesByTopicId(topicId);
    }

    public List<Note> getNotesByTagId(Long tagId) {
        return noteRepository.getNotesByTagId(tagId);
    }


    public User getActualUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return userService.getUserByUsername(userDetails.getUsername());
    }

    //-- GetDTO
    public List<NoteDTO> getAllNotesDTO() {
        return NoteDTOMapper.INSTANCE.NotesToNotesDTO(getAllNotes());
    }

    public List<NoteDTO> getNotesDTOByTopicId(Long topicId) {
        return NoteDTOMapper.INSTANCE.NotesToNotesDTO(getNotesByTopicId(topicId));
    }
//todo
    public List<NoteDTO> getNotesDTOByTagId(Long tagId) {
        return NoteDTOMapper.INSTANCE.NotesToNotesDTO(getNotesByTagId(tagId));
    }

    //-- Other


    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public Note saveNote(String note) {
        return noteRepository.save(new Note(note, getActualUser(), LocalDateTime.now()));
    }



    public Note getNoteById(Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException(" Note not found"));
    }


    public NoteHistory createNoteHistory(Note note) {
        return new NoteHistory(LocalDateTime.now(), note.getUser(), note, note.getNote());
    }


    public Note modifiesNoteText(Long noteId, String noteText) {
        Note updatedNote = getNoteById(noteId);
        NoteHistory noteHistory = createNoteHistory(updatedNote);
        updatedNote.setUser(getActualUser());
        updatedNote.setNote(noteText);
        updatedNote.getNoteHistories().add(noteHistory);
        return noteRepository.save(updatedNote);
    }

    public Note addTagToNote(Long noteId, Long tagId) {
        Note updatedNote = getNoteById(noteId);
        Tag addTag = tagService.getTagById(tagId);
        boolean tagIsPresent = tagService.getListOfTagByNoteId(noteId).
                stream().map(tag -> tag.getId()).
                anyMatch(id -> id == tagId);
        if (tagIsPresent) {
            throw new TagAlreadyExistException("Tag already exist");
        }
        NoteTag noteTag = new NoteTag(updatedNote, addTag, LocalDateTime.now());
        updatedNote.getNoteTags().add(noteTag);
        return noteRepository.save(updatedNote);
    }

    public Note deleteTagFromNote(Long noteId, Long tagId) {
        Note updatedNote = getNoteById(noteId);
/* Nice first try without noteTagService :D
        boolean tagIsPresent = tagService.getListOfTagByNoteId(noteId).
                stream().map(tag -> tag.getId()).
                anyMatch(id -> id == tagId);
        if (!tagIsPresent) {
            throw new TagNotFoundException("Tag not found");
        }
        List<NoteTag> foundNoteTagsToBeDeleted = updatedNote.getNoteTags().stream().
                filter(noteTag -> noteTag.getTag().getId() == tagId).toList();
        for(NoteTag noteTagToBeDeleted: foundNoteTagsToBeDeleted){
            updatedNote.getNoteTags().remove(noteTagToBeDeleted);
        }
        System.out.println(updatedNote.getNoteTags());
*/
        NoteTag foundNoteTag=noteTagService.findNoteTagOfANoteIdByTagId(noteId,tagId);
        updatedNote.getNoteTags().remove(foundNoteTag);
       noteTagService.deleteNoteTagById(foundNoteTag.getId());
        return noteRepository.save(updatedNote);
    }

}
