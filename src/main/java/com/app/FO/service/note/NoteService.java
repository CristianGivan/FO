package com.app.FO.service.note;

import com.app.FO.config.DateTime;
import com.app.FO.config.ServiceAll;
import com.app.FO.exceptions.*;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.NoteReminder;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.note.NoteUser;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.user.User;
import com.app.FO.repository.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {
    private NoteRepository noteRepository;

    private ServiceAll serviceAll;

    @Autowired
    public NoteService(NoteRepository noteRepository, ServiceAll serviceAll) {
        this.noteRepository = noteRepository;
        this.serviceAll = serviceAll;
    }

    //-- Post

    public Note postNote(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Note note = noteRepository.getNoteFromUserIdBySubject(logInUser.getId(), subject);
        if (note != null) {
            throw new NoteAlreadyExistException("Note with this subject already exist");
        }

        note = noteRepository.save(new Note(subject, logInUser));

        NoteUser noteUser = new NoteUser(note, logInUser);
        note.getNoteUserList().add(noteUser);

        return noteRepository.save(note);
    }

    //-- Put
    public Note putSubjectToNote(Long noteId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Note note = noteRepository.getNoteFromUserIdByNoteId(logInUser.getId(), noteId);
        if (note == null) {
            throw new NoteNotFoundException("Note not found in your list");
        }

        if (note.getSubject().equals(subject)) {
            throw new NoteAlreadyExistException("Note has already the same subject");
        }

        note.setSubject(subject);

        return noteRepository.save(note);
    }

    public Note putTypeToNote(Long noteId, String type) {
        User logInUser = serviceAll.getLogInUser();
        Note note = noteRepository.getNoteFromUserIdByNoteId(logInUser.getId(), noteId);
        if (note == null) {
            throw new NoteNotFoundException("Note not found in your list");
        }

        note.setType(type);

        return noteRepository.save(note);
    }

    public Note putUserToNote(Long noteId, Long userId) {
        User logInUser = serviceAll.getLogInUser();
        Note note = noteRepository.getNoteFromUserIdByNoteId(logInUser.getId(), noteId);
        if (note == null) {
            throw new NoteNotFoundException("Note not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        NoteUser noteUser = serviceAll.getNoteUser(noteId, userId);
        if (noteUser != null) {
            throw new NoteUserAlreadyExistException("The note already has the user");
        }

        noteUser = new NoteUser(note, user);
        note.getNoteUserList().add(noteUser);

        return noteRepository.save(note);
    }

    public Note putTagToNote(Long noteId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Note note = noteRepository.getNoteFromUserIdByNoteId(logInUser.getId(), noteId);
        if (note == null) {
            throw new NoteNotFoundException("Note not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        NoteTag noteTag = serviceAll.getNoteTag(noteId, tagId);
        if (noteTag != null) {
            throw new NoteTagAlreadyExistException("The note already has the tag");
        }

        noteTag = new NoteTag(note, tag);
        note.getNoteTagList().add(noteTag);

        return noteRepository.save(note);
    }


    public Note putReminderToNote(Long noteId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Note note = noteRepository.getNoteFromUserIdByNoteId(logInUser.getId(), noteId);
        if (note == null) {
            throw new NoteNotFoundException("Note not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        NoteReminder noteReminder = serviceAll.getNoteReminder(noteId, reminderId);
        if (noteReminder != null) {
            throw new NoteReminderAlreadyExistException("The note already has the reminder");
        }

        noteReminder = new NoteReminder(note, reminder);
        note.getNoteReminderList().add(noteReminder);

        return noteRepository.save(note);
    }


    //--Delete


    public Note deleteUserFromNote(Long noteId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Note note = noteRepository.getNoteFromUserIdByNoteId(logInUser.getId(), noteId);
        if (note == null) {
            throw new NoteNotFoundException("Note not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        NoteUser noteUser = serviceAll.getNoteUser(noteId, userId);
        if (noteUser == null) {
            throw new NoteUserNotFoundException("The note don't has the user");
        }
        note.getNoteUserList().remove(noteUser);

        return noteRepository.save(note);
    }

    public Note deleteTagFromNote(Long noteId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Note note = noteRepository.getNoteFromUserIdByNoteId(logInUser.getId(), noteId);
        if (note == null) {
            throw new NoteNotFoundException("Note not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        NoteTag noteTag = serviceAll.getNoteTag(noteId, tagId);
        if (noteTag == null) {
            throw new NoteTagNotFoundException("The note don't has the tag");
        }

        note.getNoteTagList().remove(noteTag);

        return noteRepository.save(note);
    }

    public Note deleteReminderFromNote(Long noteId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Note note = noteRepository.getNoteFromUserIdByNoteId(logInUser.getId(), noteId);
        if (note == null) {
            throw new NoteNotFoundException("Note not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        NoteReminder noteReminder = serviceAll.getNoteReminder(noteId, reminderId);
        if (noteReminder == null) {
            throw new NoteReminderNotFoundException("The note don't has the reminder");
        }

        note.getNoteReminderList().remove(noteReminder);

        return noteRepository.save(note);
    }


    public List<Note> deleteNote(Long noteId) {
        User logInUser = serviceAll.getLogInUser();

        Note note = noteRepository.getNoteFromUserIdByNoteId(logInUser.getId(), noteId);
        if (note == null) {
            throw new NoteNotFoundException("Note not found in your list");
        }
        noteRepository.delete(note);
        return getAllNote();
    }


    //-- GET


    public List<Note> getAllNote() {
        User logInUser = serviceAll.getLogInUser();
        List<Note> noteList = noteRepository.getNoteListFromUserId(logInUser.getId());
        if (noteList.isEmpty()) {
            throw new NoteNotFoundException("No note found");
        }
        return noteList;
    }

    public Note getNoteByNoteId(Long noteId) {
        User logInUser = serviceAll.getLogInUser();
        Note note = noteRepository.getNoteFromUserIdByNoteId(logInUser.getId(), noteId);
        if (note == null) {
            throw new NoteNotFoundException("No note found");
        }
        return note;
    }

    public Note getNoteBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Note note = noteRepository.getNoteFromUserIdBySubject(logInUser.getId(), subject);
        if (note == null) {
            throw new NoteNotFoundException("No note found");
        }
        return note;
    }

    public List<Note> getNoteListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Note> noteList = noteRepository.getNoteListFromUserIdBySubjectContains(logInUser.getId(), subjectContains);
        if (noteList.isEmpty()) {
            throw new NoteNotFoundException("No note found");
        }
        return noteList;
    }

    public Note getNoteByType(String type) {
        User logInUser = serviceAll.getLogInUser();
        Note note = noteRepository.getNoteFromUserIdByType(logInUser.getId(), type);
        if (note == null) {
            throw new NoteNotFoundException("No note found");
        }
        return note;
    }

    public List<Note> getNoteByTypeContains(String typeContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Note> noteList = noteRepository.getNoteListFromUserIdByTypeContains(logInUser.getId(), typeContains);
        if (noteList.isEmpty()) {
            throw new NoteNotFoundException("No note found");
        }
        return noteList;
    }

    public Note getNoteByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Note note = noteRepository.getNoteFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (note == null) {
            throw new NoteNotFoundException("No note found");
        }
        return note;
    }

    public List<Note> getNoteListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Note> noteList = noteRepository.getNoteListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (noteList.isEmpty()) {
            throw new NoteNotFoundException("No note found");
        }
        return noteList;
    }


    public List<Note> getNoteListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Note> noteList = noteRepository.getNoteListFromUserIdByUserId(logInUser.getId(), userId);
        if (noteList.isEmpty()) {
            throw new NoteNotFoundException("No note found");
        }
        return noteList;
    }

    public List<Note> getNoteListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Note> noteList = noteRepository.getNoteListFromUserIdByTagId(logInUser.getId(), tagId);
        if (noteList.isEmpty()) {
            throw new NoteNotFoundException("No note found");
        }
        return noteList;
    }

    public List<Note> getNoteListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Note> noteList = noteRepository.getNoteListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (noteList.isEmpty()) {
            throw new NoteNotFoundException("No note found");
        }
        return noteList;
    }


    //-- Other

}
