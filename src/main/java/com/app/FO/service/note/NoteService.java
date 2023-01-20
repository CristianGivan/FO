package com.app.FO.service.note;

import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.note.NoteFDTO;
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

    private NoteDTOMapper noteDTOMapper;

    public NoteService(NoteRepository noteRepository, UserService userService, TagService tagService,
                       NoteTagService noteTagService, NoteDTOMapper noteDTOMapper) {
        this.noteRepository = noteRepository;
        this.userService = userService;
        this.tagService = tagService;
        this.noteTagService = noteTagService;
        this.noteDTOMapper = noteDTOMapper;
    }

    //-- GET

    public Note getNoteByNoteId(Long noteId) {
        return noteRepository.findById(noteId).orElseThrow(
                () -> new NoteNotFoundException("Note not found"));}

    public NoteDTO getNoteDTOByNoteId(Long noteId) {
        return noteDTOMapper.NoteToNoteDTO(getNoteByNoteId(noteId));
    }

    public NoteFDTO getNoteFDTOByNoteId(Long noteId) {
        return noteDTOMapper.NoteToNoteFDTO(getNoteByNoteId(noteId));
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }


    public List<NoteDTO> getAllNotesDTO() {
        return noteDTOMapper.NotesToNotesDTO(getAllNotes());
    }

    public List<Note> getNotesByTagId(Long tagId) {
        return noteRepository.getNotesByTagId(tagId);
        //todo trebuie sa gasesc o metoda mai buna
        //return noteRepository.getNoteByNoteTagsContainingTagAndId(tagId);
    }

    public List<NoteDTO> getNotesDTOByTagId(Long tagId) {
        return noteDTOMapper.NotesToNotesDTO(getNotesByTagId(tagId));
    }

    public List<Note> getNotesByTopicId(Long topicId) {
        return noteRepository.getNotesByTopicId(topicId);
    }

    public List<NoteDTO> getNotesDTOByTopicId(Long topicId) {
        return noteDTOMapper.NotesToNotesDTO(getNotesByTopicId(topicId));
    }

    public List<NoteDTO> getNotesDTOByNoteContainsText(String containsText){
        List<Note> foundNotes =noteRepository.getNotesByNoteContains(containsText);
        return noteDTOMapper.NotesToNotesDTO(foundNotes);
    }

    //-- actual user
    public User getActualUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return userService.getUserByUsername(userDetails.getUsername());
    }

    public List<Note> getAllNotesFromLogInUser(){
        return noteRepository.getNotesByUserId(getActualUser().getId());
    }

    public List<NoteDTO> getAllNotesDTOFromLogInUser(){
        return noteDTOMapper.NotesToNotesDTO(getAllNotesFromLogInUser());
    }

    public NoteFDTO getNoteFDTOFromLogInUserByNoteId(Long noteId){
        Note foundNote=noteRepository.getNoteByUserIdAndId(getActualUser().getId(),noteId);
        return noteDTOMapper.NoteToNoteFDTO(foundNote);
    }

    public List<NoteFDTO> getNotesFDTOFromLogInUserByTagId(Long tagId){
        List<Note> foundNotes=noteRepository.getNotesFromUserIdByTagId(getActualUser().getId(),tagId);
        return noteDTOMapper.NotesToNotesFDTO(foundNotes);
    }

    public List<NoteFDTO> getNotesFDTOFromLogInUserByTopicId(Long topicId){
        List<Note> foundNotes=noteRepository.getNotesFromUserIdByTopicId(getActualUser().getId(),topicId);
        return noteDTOMapper.NotesToNotesFDTO(foundNotes);
    }
    public List<NoteDTO> getNotesDTOFromLogInUserIdByNoteContainsText(String containsText){
        List<Note> foundNotes =noteRepository.getNotesByUserIdAndNoteContains(
                getActualUser().getId(),containsText);
        return noteDTOMapper.NotesToNotesDTO(foundNotes);
    }


    //-- Set

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }


    public Note saveNote(String note) {
        return noteRepository.save(new Note(note, getActualUser(), LocalDateTime.now()));
    }

    public NoteDTO saveNoteDTO(String note) {
        return noteDTOMapper.NoteToNoteDTO(saveNote(note));
    }

    public Note modifiesNoteText(Long noteId, String noteText) {
        Note updatedNote = getNoteByNoteId(noteId);
        NoteHistory noteHistory = createNoteHistory(updatedNote);
        updatedNote.setUser(getActualUser());
        updatedNote.setNote(noteText);
        updatedNote.getNoteHistories().add(noteHistory);
        return noteRepository.save(updatedNote);
    }

    public NoteFDTO modifiesNoteFDTOText(Long noteId, String noteText){
        return noteDTOMapper.NoteToNoteFDTO(modifiesNoteText(noteId, noteText));
    }

    public Note addTagToNote(Long noteId, Long tagId) {
        Note updatedNote = getNoteByNoteId(noteId);
        //todo cred ca nu am facut cum trebuia
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
    public NoteFDTO addTagToNoteFDTO(Long noteId, Long tagId) {
        return noteDTOMapper.NoteToNoteFDTO(addTagToNote(noteId, tagId));
    }

    //--Delete

    public Note deleteTagFromNote(Long noteId, Long tagId) {
        Note updatedNote = getNoteByNoteId(noteId);
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
        NoteTag foundNoteTag = noteTagService.findNoteTagOfANoteIdByTagId(noteId, tagId);
        updatedNote.getNoteTags().remove(foundNoteTag);
        noteTagService.deleteNoteTagById(foundNoteTag.getId());
        return noteRepository.save(updatedNote);
    }
    public NoteFDTO deleteTagFromNoteFDTO(Long noteId, Long tagId) {
        return noteDTOMapper.NoteToNoteFDTO(deleteTagFromNote(noteId, tagId));
    }


    //-- Other

    public NoteHistory createNoteHistory(Note note) {
        return new NoteHistory(LocalDateTime.now(), note.getUser(), note, note.getNote());
    }








}
