package com.app.FO.service.note;

import com.app.FO.exceptions.NoteNotFoundException;
import com.app.FO.exceptions.TagAlreadyExistException;
import com.app.FO.exceptions.TagNotFoundException;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.NoteHistory;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.user.User;
import com.app.FO.repository.note.NoteRepository;
import com.app.FO.service.user.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {
    private NoteRepository noteRepository;

    private UserService userService;

    private TagService tagService;

    private NoteTagService noteTagService;

//    private NoteDTOMapper noteDTOMapper;

    public NoteService(NoteRepository noteRepository, UserService userService, TagService tagService,
                       NoteTagService noteTagService/*, NoteDTOMapper noteDTOMapper*/) {
        this.noteRepository = noteRepository;
        this.userService = userService;
        this.tagService = tagService;
        this.noteTagService = noteTagService;
//        this.noteDTOMapper = noteDTOMapper;
    }

    //-- GET

    public Note fromAnyUserGetNoteById(Long noteId) {
        return noteRepository.findById(noteId).orElseThrow(
                () -> new NoteNotFoundException("Note not found"));
    }


    public List<Note> fromAnyUserGetAllNotes() {
        return noteRepository.findAll();
    }


    public List<Note> fromAnyUserGetNotesByTagId(Long tagId) {
        return noteRepository.getNotesByTagId(tagId);
    }


    public List<Note> fromAnyUserGetNotesByTopicId(Long topicId) {
        return noteRepository.getNotesByTopicId(topicId);
    }

    public List<Note> fromAnyUserGetNotesByNoteThatContainsText(String containsText) {
        return noteRepository.getNotesByNoteContains(containsText);
    }

    //-- actual user
    public User getActualUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return userService.getUserByUsername(userDetails.getUsername());
    }

    public List<Note> fromLogInUserGetAllNotes() {
        return noteRepository.getNotesByUserId(getActualUser().getId());
    }

    public Note fromLogInUserGetNoteByNoteId(Long noteId) {
        return noteRepository.getNoteByUserIdAndId(getActualUser().getId(), noteId);
    }

    public List<Note> fromLogInUserGetNotesByTagId(Long tagId) {
        return noteRepository.getNotesFromUserIdByTagId(getActualUser().getId(), tagId);
    }

    public List<Note> fromLogInUserGetNotesByTopicId(Long topicId) {
        return noteRepository.getNotesFromUserIdByTopicId(getActualUser().getId(), topicId);
    }

    public List<Note> fromLogInUserGetNotesByNoteThatContainsText(String containsText) {
        return noteRepository.getNotesByUserIdAndNoteContains(getActualUser().getId(), containsText);
    }


    //-- Set

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }


    public Note forAnyUserPostNewNote(String note) {
        return noteRepository.save(new Note(note, getActualUser(), LocalDateTime.now()));
    }
    public Note forAnyUserPutNoteText(Long noteId, String noteText) {
        Note updatedNote = fromAnyUserGetNoteById(noteId);
        NoteHistory noteHistory = createNoteHistory(updatedNote);
        updatedNote.setUser(getActualUser());
        updatedNote.setNote(noteText);
        updatedNote.getNoteHistories().add(noteHistory);
        return noteRepository.save(updatedNote);
    }

    public Note forAnyUserPutTagToNote(Long noteId, Long tagId) {
        Note updatedNote = fromAnyUserGetNoteById(noteId);
        Tag addTag = tagService.getTagById(tagId);
        if (noteRepository.noteHasTag(noteId, tagId)) {
            throw new TagAlreadyExistException("Tag already exist");
        }
        NoteTag newNoteTag = new NoteTag(updatedNote, addTag);
        updatedNote.getNoteTags().add(newNoteTag);
        return noteRepository.save(updatedNote);
    }

    public Note forLogInUserPutTagToNote(Long noteId, Long tagId) {
        Note updatedNote = fromLogInUserGetNoteByNoteId(noteId);
        if (updatedNote == null) {
            throw new NoteNotFoundException("Note not found!");
        }
        Tag addTag = tagService.getTagOfLogInUserIdAndTagId(tagId);
        if (addTag == null) {
            throw new TagNotFoundException("Tag not found!");
        }
        if (noteRepository.noteHasTag(noteId, tagId)) {
            throw new TagAlreadyExistException("Tag already exist");
        }
        NoteTag newNoteTag = new NoteTag(updatedNote, addTag);
        updatedNote.getNoteTags().add(newNoteTag);
        return noteRepository.save(updatedNote);
    }

    //--Delete

    public Note forAnyUserDeleteTagFromNote(Long noteId, Long tagId) {
        Note updatedNote = fromAnyUserGetNoteById(noteId);
        NoteTag foundNoteTag = noteTagService.findNoteTagOfANoteIdByTagId(noteId, tagId);
        updatedNote.getNoteTags().remove(foundNoteTag);
        noteTagService.deleteNoteTagById(foundNoteTag.getId());
        return noteRepository.save(updatedNote);
    }



    //-- Other

    public NoteHistory createNoteHistory(Note note) {
        return new NoteHistory(LocalDateTime.now(), note.getUser(), note, note.getNote());
    }


}
