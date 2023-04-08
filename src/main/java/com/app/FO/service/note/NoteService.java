package com.app.FO.service.note;

import com.app.FO.exceptions.*;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.NoteHistory;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.remainder.Remainder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.topic.TopicNote;
import com.app.FO.model.user.User;
import com.app.FO.repository.note.NoteRepository;
import com.app.FO.service.remainder.RemainderService;
import com.app.FO.service.tag.TagService;
import com.app.FO.service.topic.TopicNoteService;
import com.app.FO.service.topic.TopicService;
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

    private TagService tagService;

    private NoteTagService noteTagService;

    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicNoteService topicNoteService;

    @Autowired
    private RemainderService remainderService;

    //    private NoteDTOMapper noteDTOMapper;
    @Autowired
    public NoteService(NoteRepository noteRepository, UserService userService, TagService tagService,
                       NoteTagService noteTagService/*, NoteDTOMapper noteDTOMapper*/) {
        this.noteRepository = noteRepository;
        this.userService = userService;
        this.tagService = tagService;
        this.noteTagService = noteTagService;
//        this.noteDTOMapper = noteDTOMapper;
    }

    //-- Get admin

    public Note adminGetNoteById(Long noteId) {
        return noteRepository.findById(noteId).orElseThrow(
                () -> new NoteNotFoundException("Note not found"));
    }


    public List<Note> adminGetAllNotes() {
        return noteRepository.findAll();
    }


    public List<Note> adminGetNotesByTagId(Long tagId) {
        return noteRepository.getNotesByTagId(tagId);
    }


    public List<Note> adminGetNotesByTopicId(Long topicId) {
        return noteRepository.getNotesByTopicId(topicId);
    }

    public List<Note> adminGetNotesByNoteThatContainsText(String containsText) {
        return noteRepository.getNotesByNoteContains(containsText);
    }

    //-- Get
    public User getLogInUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return userService.getUserByUsername(userDetails.getUsername());
    }

    public List<Note> getAllNotes() {
        return noteRepository.getNotesByUserId(getLogInUser().getId());
    }

    public Note getNoteByNoteId(Long noteId) {
        return noteRepository.getNoteByUserIdAndId(getLogInUser().getId(), noteId);
    }

    public List<Note> getNotesByTagId(Long tagId) {
        return noteRepository.getNotesFromUserIdByTagId(getLogInUser().getId(), tagId);
    }

    public List<Note> getNotesByTopicId(Long topicId) {
        return noteRepository.getNotesFromUserIdByTopicId(getLogInUser().getId(), topicId);
    }

    public List<Note> getNotesByNoteThatContainsText(String containsText) {
        return noteRepository.getNotesByUserIdAndNoteContains(getLogInUser().getId(), containsText);
    }


    //-- Post

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }


    public Note adminPostNewNote(String note) {
        return noteRepository.save(new Note(note, getLogInUser(), LocalDateTime.now()));
    }

    //-- Put admin


    public Note adminPutNoteText(Long noteId, String noteText) {
        Note updatedNote = adminGetNoteById(noteId);
        NoteHistory noteHistory = createNoteHistory(updatedNote);
        updatedNote.setUser(getLogInUser());
        updatedNote.setNote(noteText);
        updatedNote.getNoteHistoryList().add(noteHistory);
        return noteRepository.save(updatedNote);
    }

    public Note adminPutTagToNote(Long noteId, Long tagId) {
        Note updatedNote = adminGetNoteById(noteId);
        Tag addTag = tagService.getTagById(tagId);
        if (noteRepository.noteHasTag(noteId, tagId)) {
            throw new TagAlreadyExistException("Tag already exist");
        }
        NoteTag newNoteTag = new NoteTag(updatedNote, addTag);
        updatedNote.getNoteTagList().add(newNoteTag);
        return noteRepository.save(updatedNote);
    }

    //-- Put

    public Note putTagToNote(Long noteId, Long tagId) {
        Note updatedNote = getNoteByNoteId(noteId);
        Tag addTag = tagService.getTagByTagIdFromUser(tagId);// to make sure that the tag is accessible form current user
        checkIfNoteAndTagExist(updatedNote, addTag);

        if (noteRepository.noteHasTag(noteId, tagId)) {
            throw new TagAlreadyExistException("Tag already exist");
        }
        NoteTag newNoteTag = new NoteTag(updatedNote, addTag);
        updatedNote.getNoteTagList().add(newNoteTag);
        return noteRepository.save(updatedNote);
    }


    public Note putTopicToNote(Long noteId, Long topicId) {
        Note updatedNote = getNoteByNoteId(noteId);
        Topic addTopic = topicService.getTopicByTopicIdFromUser(topicId);
        checkIfNoteAndTopicExist(updatedNote, addTopic);

        if (noteRepository.noteHasTopic(noteId, topicId)) {
            throw new TopicAlreadyExistException("Topic already exist");
        }
        TopicNote newTopicNote = new TopicNote(addTopic, updatedNote);
        updatedNote.getTopicNoteList().add(newTopicNote);
        return noteRepository.save(updatedNote);
    }

    public Note putRemainderToNote(Long noteId, Long remainderId) {
        /*
         * 1. Find parameter1 by id (from log in user)
         * 2. Find parameter2 if topic(from log in user)
         * 3. Check if there are not null else throw an exception)
         * 4. Check if parameter1 has parameter2
         * 5. Crate an entry in linking table
         * 5. Add parameter2 in parameter1 list
         * 6. Save parameter1 */

        Note updatedNote = getNoteByNoteId(noteId);
        Remainder addRemainder = remainderService.getRemainderByRemainderIdFromUser(remainderId);

        checkIfNoteAndRemainderExist(updatedNote, addRemainder);

        if (noteRepository.noteHasRemainder(noteId, remainderId)) {
            throw new RemainderAlreadyExistException("Remainder already exist");
        }
        updatedNote.getRemainderList().add(addRemainder);
        addRemainder.setNote(updatedNote);
        return noteRepository.save(updatedNote);
    }

    //--Delete

    public Note adminDeleteTagFromNote(Long noteId, Long tagId) {
        Note updatedNote = adminGetNoteById(noteId);
        NoteTag foundNoteTag = noteTagService.findNoteTagOfANoteIdByTagId(noteId, tagId);
        checkIfNoteAndNoteTagExist(updatedNote, foundNoteTag);
        updatedNote.getNoteTagList().remove(foundNoteTag);
        noteTagService.deleteNoteTagById(foundNoteTag.getId());
        return noteRepository.save(updatedNote);
    }

    /*
     * If a note is found by user it can be edited by him
     * */
    //todo tbt
    public Note deleteTagFromNote(Long noteId, Long tagId) {
        Note updatedNote = getNoteByNoteId(noteId);
        NoteTag foundNoteTag = noteTagService.findNoteTagOfANoteIdByTagId(noteId, tagId);
        checkIfNoteAndNoteTagExist(updatedNote, foundNoteTag);
        //updatedNote.getNoteTags().remove(foundNoteTag);//no needed we have persist
        noteTagService.deleteNoteTagById(foundNoteTag.getId());
        return noteRepository.save(updatedNote);
    }

    public Note deleteTopicFromNote(Long noteId, Long topicId) {
        Note updatedNote = getNoteByNoteId(noteId);
        TopicNote foundNTopicNote = topicNoteService.getTopicNoteOfANoteIdByTopicId(noteId, topicId);
        checkIfNoteAndTopicNoteExist(updatedNote, foundNTopicNote);
        topicNoteService.deleteTopicNoteById(foundNTopicNote.getId());
        return noteRepository.save(updatedNote);
    }

    public Note deleteRemainderFromNote(Long noteId, Long remainderId) {
        Note updatedNote = getNoteByNoteId(noteId);
        Remainder remainder =remainderService.getRemainderByRemainderIdFromUser(remainderId);//todo -c get from note
        checkIfNoteAndRemainderExist(updatedNote,remainder);
        //remainderService.deleteTopicNoteById(foundNTopicNote.getId());//todo -c create delete methode
        return noteRepository.save(updatedNote);
    }

    //-- Other

    public NoteHistory createNoteHistory(Note note) {
        return new NoteHistory(LocalDateTime.now(), note.getUser(), note, note.getNote());
    }

    //-- Checks

    //todo TBT
    private void checkIfNoteAndTagExist(Note note, Tag tag) {
        checkIfNoteExist(note);
        checkIfTagExist(tag);
    }

    private void checkIfNoteAndNoteTagExist(Note note, NoteTag noteTag) {
        checkIfNoteExist(note);
        checkIfNoteTagIsAtNote(noteTag);
    }

    private void checkIfNoteAndTopicNoteExist(Note note, TopicNote topicNote) {
        checkIfNoteExist(note);
        checkIfTopicNoteIsAtNote(topicNote);
    }

    private void checkIfNoteAndTopicExist(Note note, Topic topic) {
        checkIfNoteExist(note);
        checkIfTopicExist(topic);
    }

    private void checkIfNoteAndRemainderExist(Note note, Remainder remainder) {
        checkIfNoteExist(note);
        checkIfRemainderExist(remainder);
    }

    //todo TBT
    private void checkIfNoteExist(Note note) {
        if (note == null) {
            throw new NoteNotFoundException("Note not found!");
        }
    }

    //todo TBT
    private void checkIfTagExist(Tag tag) {
        if (tag == null) {
            throw new TagNotFoundException("Tag not found!");
        }
    }

    //todo TBT
    private void checkIfTopicExist(Topic topic) {
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found!");
        }
    }

    private void checkIfRemainderExist(Remainder remainder) {
        if (remainder == null) {
            throw new RemainderNotFoundException("Remainder not found!");
        }
    }

    //todo TBT
    private void checkIfNoteTagIsAtNote(NoteTag noteTag) {
        if (noteTag == null) {
            throw new NoteTagNotFoundException("Tag not linked to note!");
        }
    }

    private void checkIfTopicNoteIsAtNote(TopicNote topicNote) {
        if (topicNote == null) {
            throw new TopicNoteNotFoundException("Topic not linked to note!");
        }
    }

    private void checkIfRemainderIsAtNote(Remainder remainder) {
        if (remainder == null) {
            throw new RemainderNotFoundException("Remainder not linked to note!");
        }
    }

}
