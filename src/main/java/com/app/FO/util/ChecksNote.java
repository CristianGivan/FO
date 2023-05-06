package com.app.FO.util;

import com.app.FO.exceptions.*;
import com.app.FO.model.note.Note;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChecksNote {
    private NoteRepository noteRepository;

    @Autowired
    public ChecksNote(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
    public void checkIsNote(Note note){
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }
    }

    public void checkIsNoteList(List<Note> noteList){
        if(noteList.size()==0){
            throw new NoteNotFoundException("No Note found!");
        }
    }

    public void checkIsNoteWithTheSame(Note note){
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }
    }

    public void checkIsNoteWithNoteText(String noteText, User user){
        Note existingNote =noteRepository.getNoteFromUserIdByNoteText(user.getId(),noteText);
        if (existingNote!=null){
            throw new NoteAlreadyExistException("Note with this text already exist");
        }
    }
    public void checkIsNoteAndTagAndAreLinked(Note note, Tag tag) {
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }else if (!isTag(tag)) {
            throw new TagNotFoundException("Tag not found!");
        }else if (!NoteHasTag(note, tag)) {
            throw new NoteTagNotFoundException("Tag not linked to note!");
        }
    }

    public void checkIsNoteAndTagAndAreNotLinked(Note note, Tag tag) {
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }else if (!isTag(tag)) {
            throw new TagNotFoundException("Tag not found!");
        }else if (NoteHasTag(note, tag)) {
            throw new TagAlreadyExistException("Tag already exist");
        }
    }

    public void checkIsNoteAndTopicAndAreLinked(Note note, Topic topic) {
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }else if (!isTopic(topic)) {
            throw new TopicNotFoundException("Topic not found!");
        }else if (!NoteHasTopic(note, topic)) {
            throw new TopicNoteNotFoundException("Topic not linked to note!");
        }
    }

    public void checkIsNoteAndTopicAndAreNotLinked(Note note, Topic topic) {
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }else if (!isTopic(topic)) {
            throw new TopicNotFoundException("Topic not found!");
        }else if (NoteHasTopic(note, topic)) {
            throw new TopicAlreadyExistException("Topic already exist");
        }
    }

    public void checkIsNoteAndReminderAndAreLiked(Note note, Reminder reminder) {
        if (!isNote(note)) {
            throw new NoteNotFoundException("Note not found!");
        } else if (!isReminder(reminder)) {
            throw new ReminderNotFoundException("Reminder not found!");
        }else if (!NoteHasReminder(note, reminder)) {
            throw new ReminderNotFoundException("Reminder not linked to note!");
        }
    }

    public void checkIsNoteAndReminderAndAreNotLiked(Note note, Reminder reminder) {
        if (!isNote(note)) {
            throw new NoteNotFoundException("Note not found!");
        } else if (!isReminder(reminder)) {
            throw new ReminderNotFoundException("Reminder not found!");
        }else if (NoteHasReminder(note, reminder)) {
            throw new ReminderAlreadyExistException("Reminder already exist");
        }
    }

    public void checkIsNoOtherNoteAtReminder(Reminder reminder) {
        if (reminder.getNote() != null) {
            throw new ReminderAlreadyExistException("Another note already exist, do you want to replace it?");
        }
    }
    public void checkIsNoteAndUserAndAreLiked(Note note, User user) {
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }else if(!isUser(user)){
            throw new UserNotFoundException("User not found");
        }else if(!NoteHasUser(note, user)) {
            throw new UserNotFoundException("User is not linked to note");
        }
    }
    public void checkIsNoteAndUserAndAreNotLiked(Note note, User user) {
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }else if(!isUser(user)){
            throw new UserNotFoundException("User not found");
        }else if(NoteHasUser(note, user)) {
            throw new UserAlreadyExistException("User linked to note");
        }
    }

    private Boolean isNote(Note note) {
        if (note == null) {
            return false;
        }
        return true;
    }

    private Boolean isTag(Tag tag) {
        if (tag == null) {
            return false;
        }
        return true;
    }

    private Boolean isTopic(Topic topic) {
        if (topic == null) {
            return false;
        }
        return true;
    }

    private Boolean isReminder(Reminder reminder) {
        if (reminder == null) {
            return false;
        }
        return true;
    }

    private Boolean isUser(User user) {
        if (user == null) {
            return false;
        }
        return true;
    }

    private Boolean NoteHasTag(Note note, Tag tag) {
        if (noteRepository.NoteIdHasTagId(note.getId(), tag.getId())) {
            return true;
        }
        return false;
    }

    private Boolean NoteHasTopic(Note note, Topic topic) {
        if (noteRepository.NoteIdHasTopicId(note.getId(), topic.getId())) {
            return true;
        }
        return false;
    }

    private Boolean NoteHasReminder(Note note, Reminder reminder) {
        if (noteRepository.NoteIdHasReminderId(note.getId(), reminder.getId())) {
            return true;
        }
        return false;
    }

    private Boolean NoteHasUser(Note note, User user) {
        if (noteRepository.NoteIdHasUserId(note.getId(), user.getId())) {
            return true;
        }
        return false;

    }

}
