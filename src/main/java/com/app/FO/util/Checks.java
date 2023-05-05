package com.app.FO.util;

import com.app.FO.exceptions.*;
import com.app.FO.model.note.Note;
import com.app.FO.model.remainder.Remainder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Checks {
    private NoteRepository noteRepository;

    @Autowired
    public Checks(NoteRepository noteRepository) {
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

    public void checkIsNoteWithNoteText(User user, String noteText){
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

    public void checkIsNoteAndRemainderAndAreLiked(Note note, Remainder remainder) {
        if (!isNote(note)) {
            throw new NoteNotFoundException("Note not found!");
        } else if (!isRemainder(remainder)) {
            throw new RemainderNotFoundException("Remainder not found!");
        }else if (!NoteHasRemainder(note, remainder)) {
            throw new RemainderNotFoundException("Remainder not linked to note!");
        }
    }

    public void checkIsNoteAndRemainderAndAreNotLiked(Note note, Remainder remainder) {
        if (!isNote(note)) {
            throw new NoteNotFoundException("Note not found!");
        } else if (!isRemainder(remainder)) {
            throw new RemainderNotFoundException("Remainder not found!");
        }else if (NoteHasRemainder(note, remainder)) {
            throw new RemainderAlreadyExistException("Remainder already exist");
        }
    }

    public void checkIsNoOtherNoteAtRemainder(Remainder remainder) {
        if (remainder.getNote() != null) {
            throw new RemainderAlreadyExistException("Another note already exist, do you want to replace it?");
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

    private Boolean isRemainder(Remainder remainder) {
        if (remainder == null) {
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

    private Boolean NoteHasRemainder(Note note, Remainder remainder) {
        if (noteRepository.NoteIdHasRemainderId(note.getId(), remainder.getId())) {
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
