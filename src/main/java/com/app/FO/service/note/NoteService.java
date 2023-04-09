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
        isNoteAndTag(updatedNote, addTag);
        //todo -c
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
        isNoteAndTopic(updatedNote, addTopic);
        //todo -c
        if (noteRepository.isTopicAtNote(noteId, topicId)) {
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

        Note note = getNoteByNoteId(noteId);
        Remainder remainder = remainderService.getRemainderByRemainderIdFromUser(remainderId);
        isNoteAndNoteHasNotRemainder(note, remainder);
        isNoOtherNoteAtRemainder(remainder); // one remainder hase only one note shall throw exception to don't overwrite.
        note.getRemainderList().add(remainder);
        remainder.setNote(note);
        return noteRepository.save(note);
    }

    //--Delete

    public Note adminDeleteTagFromNote(Long noteId, Long tagId) {
        Note updatedNote = adminGetNoteById(noteId);
        Tag tag = tagService.getTagByTagIdFromUser(tagId);
        NoteTag foundNoteTag = noteTagService.findNoteTagOfANoteIdByTagId(noteId, tagId);
        isNoteAndTagAndLinked(updatedNote, tag, foundNoteTag);
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
        Tag tag = tagService.getTagByTagIdFromUser(tagId);
        NoteTag foundNoteTag = noteTagService.findNoteTagOfANoteIdByTagId(noteId, tagId);
        isNoteAndTagAndLinked(updatedNote, tag, foundNoteTag);
        noteTagService.deleteNoteTagById(foundNoteTag.getId());
        return noteRepository.save(updatedNote);
    }

    public Note deleteTopicFromNote(Long noteId, Long topicId) {
        Note updatedNote = getNoteByNoteId(noteId);
        Topic topic = topicService.getTopicByTopicIdFromUser(topicId);
        TopicNote topicNote = topicNoteService.getTopicNoteOfANoteIdByTopicId(noteId, topicId);
        isNoteAndTopicAndLink(updatedNote, topic, topicNote);
        topicNoteService.deleteTopicNoteById(topicNote.getId());
        return noteRepository.save(updatedNote);
    }

    public Note deleteRemainderFromNote(Long noteId, Long remainderId) {
        /*
         * 1. Find param1 and param2
         * 2. Check if
         *   a. param1 exist
         *   b. param2 exist
         *   c. param2 is at param1
         * 3. Delete param2 from param1
         * 4. Save param1, no needed to save param2 because there is persist*/
        Note note = getNoteByNoteId(noteId);
        Remainder remainder = remainderService.getRemainderByRemainderIdFromUser(remainderId);
        isNoteAndRemainderAndLiked(note, remainder);
        remainder.setNote(null);
        return noteRepository.save(note);
    }

    //-- Other

    public NoteHistory createNoteHistory(Note note) {
        return new NoteHistory(LocalDateTime.now(), note.getUser(), note, note.getNote());
    }

    //-- Checks

    public Boolean isNoteAndNoteHasNotTopic(Note note, Topic topic) {
        //todo
        return true;
    }

    public Boolean isNoteAndNoteHasNotRemainder(Note note, Remainder remainder) {
        isNote(note);
        isNotRemainderAtNote(note, remainder);
        return true;
    }

    private Boolean isNoteAndTagAndLinked(Note note, Tag tag, NoteTag noteTag) {
        isNoteAndTag(note, tag);
        isNotTagAtNote(noteTag);
        return true;
    }

    private Boolean isNoteAndTopicAndLink(Note note, Topic topic, TopicNote topicNote) {
        isNoteAndTopic(note, topic);
        isNotTopicAtNote(topicNote);
        return true;
    }

    private Boolean isNoteAndRemainderAndLiked(Note note, Remainder remainder) {
        isNoteAndRemainder(note, remainder);
        isRemainderAtNote(note, remainder);
        return true;
    }

    private Boolean isNoteAndTag(Note note, Tag tag) {
        isNote(note);
        isTag(tag);
        return true;
    }

    private Boolean isNoteAndTopic(Note note, Topic topic) {
        isNote(note);
        isTopic(topic);
        return true;
    }

    private Boolean isNoteAndRemainder(Note note, Remainder remainder) {
        isNote(note);
        isRemainder(remainder);
        return true;
    }

    //todo TBT
    private Boolean isNote(Note note) {
        if (note == null) {
            throw new NoteNotFoundException("Note not found!");
        }
        return true;
    }

    //todo TBT
    private Boolean isTag(Tag tag) {
        if (tag == null) {
            throw new TagNotFoundException("Tag not found!");
        }
        return true;
    }

    //todo TBT
    private Boolean isTopic(Topic topic) {
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found!");
        }
        return true;
    }

    private Boolean isRemainder(Remainder remainder) {
        if (remainder == null) {
            throw new RemainderNotFoundException("Remainder not found!");
        }
        return true;
    }

    //todo TBT
    private Boolean isNotTagAtNote(NoteTag noteTag) {
        if (noteTag == null) {
            throw new NoteTagNotFoundException("Tag not linked to note!");
        }
        return true;
    }

    private Boolean isNotTopicAtNote(TopicNote topicNote) {
        if (topicNote == null) {
            throw new TopicNoteNotFoundException("Topic not linked to note!");
        }
        return true;
    }

    private Boolean isRemainderAtNote(Note note, Remainder remainder) {

        if (!remainderService.isRemainderIdAtNoteId(note.getId(), remainder.getId())) {
            throw new RemainderNotFoundException("Remainder not linked to note!");
        }
        return true;
    }

    private boolean isNotRemainderAtNote(Note note, Remainder remainder) {
        if (noteRepository.isRemainderAtNote(note.getId(), remainder.getId())) {
            throw new RemainderAlreadyExistException("Remainder already exist");
        }
        return true;
    }
    private boolean isNoOtherNoteAtRemainder(Remainder remainder) {
        if (remainder.getNote()!=null) {
            throw new RemainderAlreadyExistException("Another note already exist, do you want to replace it?");
        }
        return true;
    }
}
