package com.app.FO.service.note;

import com.app.FO.model.note.*;
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
import com.app.FO.util.Checks;
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

    @Autowired
    private Checks checks;
    @Autowired
    private NoteUserService noteUserService;
    @Autowired
    private NoteRemainderService noteRemainderService;

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
/*

    //-- Post admin

    public Note adminPostNewNote(String noteText) {
        User user = getLogInUser();
        Note note = new Note(noteText, user);// todo tbd cam be created without save it 2 times
        NoteUser noteUser = new NoteUser(note, user);
        note.getNoteUserList().add(noteUser);
        return noteRepository.save(note);
    }

    //-- Put admin


        public Note adminPutNoteText(Long noteId, String noteText) {
            Note updatedNote = adminGetNoteById(noteId);
            NoteHistory noteHistory = createNoteHistory(updatedNote);
            updatedNote.setCreator(getLogInUser());
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

    //--Delete addmin
    public Note adminDeleteTagFromNote(Long noteId, Long tagId) {
        Note note = adminGetNoteById(noteId);
        Tag tag = tagService.getTagByTagIdFromUser(tagId);
        NoteTag foundNoteTag = noteTagService.findNoteTagOfANoteIdByTagId(noteId, tagId);
        checkForNote.checkIsNoteAndTagAndAreLinked(note, tag);
        note.getNoteTagList().remove(foundNoteTag);
        noteTagService.deleteNoteTagById(foundNoteTag.getId());
        return noteRepository.save(note);
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
    }*/




    //-- Post

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    //-- Post

    public Note postNewNote(String noteText) {
        User user = getLogInUser();
        checks.checkIsNoteWithNoteText(user,noteText);
        Note note = new Note(noteText, user);
        NoteUser noteUser = new NoteUser(note, user);
        note.getNoteUserList().add(noteUser);
        return noteRepository.save(note);
    }


    //-- Put

    public Note putTagToNote(Long noteId, Long tagId) {
        Note note = getNoteByNoteId(noteId);
        Tag tag = tagService.getTagByTagIdFromUser(tagId);// to make sure that the tag is accessible form current user
        checks.checkIsNoteAndTagAndAreNotLinked(note, tag);
        NoteTag newNoteTag = new NoteTag(note, tag);
        note.getNoteTagList().add(newNoteTag);
        return noteRepository.save(note);
    }


    public Note putTopicToNote(Long noteId, Long topicId) {
        Note note = getNoteByNoteId(noteId);
        Topic topic = topicService.getTopicByTopicIdFromUser(topicId);
        checks.checkIsNoteAndTopicAndAreNotLinked(note, topic);
        TopicNote newTopicNote = new TopicNote(topic, note);
        note.getTopicNoteList().add(newTopicNote);
        return noteRepository.save(note);
    }

    public Note putRemainderToNote(Long noteId, Long remainderId) {
        /*
         * 1. Find parameter1 by id (from log in user)
         * 2. Find parameter2 by id (from log in user)
         * 3. Check if there are not null else throw an exception)
         * 4. Check if parameter1 has parameter2
         * 5. Crate an entry in linking table
         * 5. Add parameter2 in parameter1 list
         * 6. Save parameter1 */

        Note note = getNoteByNoteId(noteId);
        Remainder remainder = remainderService.getRemainderByRemainderIdFromUser(remainderId);
        checks.checkIsNoteAndRemainderAndAreNotLiked(note, remainder);
        checks.checkIsNoOtherNoteAtRemainder(remainder); // one remainder hase only one note shall throw exception to don't overwrite.
        NoteRemainder noteRemainder=new NoteRemainder(note, remainder);
        note.getNoteRemainderList().add(noteRemainder);
        remainder.setNote(note);
        return noteRepository.save(note);
    }

    public Note putUserToNote(Long noteId, Long userId) {
        /*
         * 1. Find parameter1 by id (from log in user)
         * 2. Find parameter2 by id
         * 3. Check if there are not null else throw an exception)
         * 4. Check if parameter1 do not have has parameter2
         * 5. Crate an entry in linking table
         * 5. Add parameter2 in parameter1 list
         * 6. Save parameter1
         * */

        Note note = getNoteByNoteId(noteId);
        User user = userService.findUserById(userId);
        checks.checkIsNoteAndUserAndAreNotLiked(note, user);
        NoteUser noteUser = new NoteUser(note, user);
        note.getNoteUserList().add(noteUser);
        return noteRepository.save(note);
    }

    //-- Get
    public User getLogInUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return userService.getUserByUsername(userDetails.getUsername());
    }

    public List<Note> getNoteList() {
        List<Note> noteList =noteRepository.getNoteListByUserId(getLogInUser().getId());
        checks.checkIsNoteList(noteList);
        return noteList;
    }

    public Note getNoteByNoteId(Long noteId) {
        Note note = noteRepository.getNoteByIdAndUserId(noteId,getLogInUser().getId());
        checks.checkIsNote(note);
        return note;
    }

    public List<Note> getNoteListByTagId(Long tagId) {
        List<Note> noteList =noteRepository.getNoteListFromUserIdByTagId(getLogInUser().getId(), tagId);
        checks.checkIsNoteList(noteList);
        return noteList;
    }
    public List<Note> getNoteListByRemainderId(Long remainderId) {
        List<Note> noteList =noteRepository.getNoteListFromUserIdByRemainderId(getLogInUser().getId(), remainderId);
        checks.checkIsNoteList(noteList);
        return noteList;
    }

    public List<Note> getNoteListByTopicId(Long topicId) {
        List<Note> noteList =noteRepository.getNoteListFromUserIdByTopicId(getLogInUser().getId(), topicId);
        checks.checkIsNoteList(noteList);
        return noteList;
    }

    public List<Note> getNoteListByNoteThatContainsText(String containsText) {
        List<Note> noteList =noteRepository.getNotesByCreatorIdAndNoteTextContains(getLogInUser().getId(), containsText);
        checks.checkIsNoteList(noteList);
        return noteList;
    }

    //--Delete

    public Note deleteNoteByNoteId(Long noteId){
        /*
        * get note by Id
        * check if note exist
        * delete nie
        * */
        Note note =getNoteByNoteId(noteId);
        checks.checkIsNote(note);
        noteRepository.delete(note);
        return note;
    }


    /*
     * If a note is found by user it can be edited by him
     * */
    //todo tbt
    public Note deleteTagFromNote(Long noteId, Long tagId) {
        Note note = getNoteByNoteId(noteId);
        Tag tag = tagService.getTagByTagIdFromUser(tagId);
        checks.checkIsNoteAndTagAndAreLinked(note, tag);
        noteTagService.deleteNoteTagById(noteId,tagId);
        return noteRepository.save(note);
    }

    public Note deleteTopicFromNote(Long noteId, Long topicId) {
        Note note = getNoteByNoteId(noteId);
        Topic topic = topicService.getTopicByTopicIdFromUser(topicId);
        checks.checkIsNoteAndTopicAndAreLinked(note, topic);
        topicNoteService.deleteTopicNoteById(topicId, noteId);
        return noteRepository.save(note);
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
        checks.checkIsNoteAndRemainderAndAreLiked(note, remainder);
        noteRemainderService.deleteNoteRemainderFormNoteIdByRemainderId(noteId,remainderId);
        remainder.setNote(null);
        return noteRepository.save(note);
    }

    public Note deleteUserFromNote(Long noteId, Long userId) {
        /*
         * 1. Find param1 and param2
         * 2. Check if
         *   a. param1 exist
         *   b. param2 exist
         *   c. param2 is at param1
         * 3. Delete param2 from param1
         * 4. Save param1, no needed to save param2 because there is persist*/
        Note note = getNoteByNoteId(noteId);
        User user=userService.getUserByUserId(userId);
        checks.checkIsNoteAndUserAndAreLiked(note, user);
        noteUserService.deleteNoteUserFormNoteIdByUserId(noteId,userId);
        return noteRepository.save(note);
    }

    //-- Other

    public NoteHistory createNoteHistory(Note note) {
        return new NoteHistory(LocalDateTime.now(), note.getCreator(), note, note.getNoteText());
    }

}
