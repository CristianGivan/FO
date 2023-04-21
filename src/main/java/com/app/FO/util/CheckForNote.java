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

@Configuration
public class CheckForNote {
    private NoteRepository noteRepository;

    @Autowired
    public CheckForNote(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
    public void checkIsNote(Note note){
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }
    }

    public void checkIsNoteAndTagAndAreLinked(Note note, Tag tag) {
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }else if (!isTag(tag)) {
            throw new TagNotFoundException("Tag not found!");
        }else if (!isTagLinkedToNote(note, tag)) {
            throw new NoteTagNotFoundException("Tag not linked to note!");
        }
    }

    public void checkIsNoteAndTagAndAreNotLinked(Note note, Tag tag) {
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }else if (!isTag(tag)) {
            throw new TagNotFoundException("Tag not found!");
        }else if (isTagLinkedToNote(note, tag)) {
            throw new TagAlreadyExistException("Tag already exist");
        }
    }

    public void checkIsNoteAndTopicAndAreLinked(Note note, Topic topic) {
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }else if (!isTopic(topic)) {
            throw new TopicNotFoundException("Topic not found!");
        }else if (!isTopicLinkedToNote(note, topic)) {
            throw new TopicNoteNotFoundException("Topic not linked to note!");
        }
    }

    public void checkIsNoteAndTopicAndAreNotLinked(Note note, Topic topic) {
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }else if (!isTopic(topic)) {
            throw new TopicNotFoundException("Topic not found!");
        }else if (isTopicLinkedToNote(note, topic)) {
            throw new TopicAlreadyExistException("Topic already exist");
        }
    }

    public void checkIsNoteAndRemainderAndAreLiked(Note note, Remainder remainder) {
        if (!isNote(note)) {
            throw new NoteNotFoundException("Note not found!");
        } else if (!isRemainder(remainder)) {
            throw new RemainderNotFoundException("Remainder not found!");
        }else if (!isRemainderLinkedToNote(note, remainder)) {
            throw new RemainderNotFoundException("Remainder not linked to note!");
        }
    }

    public void checkIsNoteAndRemainderAndAreNotLiked(Note note, Remainder remainder) {
        if (!isNote(note)) {
            throw new NoteNotFoundException("Note not found!");
        } else if (!isRemainder(remainder)) {
            throw new RemainderNotFoundException("Remainder not found!");
        }else if (isRemainderLinkedToNote(note, remainder)) {
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
        }else if(!isUserLinkedToNote(note, user)) {
            throw new UserNotFoundException("User is not linked to note");
        }
    }
    public void checkIsNoteAndUserAndAreNotLiked(Note note, User user) {
        if(!isNote(note)){
            throw new NoteNotFoundException("Note not found!");
        }else if(!isUser(user)){
            throw new UserNotFoundException("User not found");
        }else if(isUserLinkedToNote(note, user)) {
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

    private Boolean isTagLinkedToNote(Note note, Tag tag) {
        if (noteRepository.noteHasTag(note.getId(), tag.getId())) {
            return true;
        }
        return false;
    }

    private Boolean isTopicLinkedToNote(Note note, Topic topic) {
        if (noteRepository.isTopicAtNote(note.getId(), topic.getId())) {
            return true;
        }
        return false;
    }

    private Boolean isRemainderLinkedToNote(Note note, Remainder remainder) {
        if (noteRepository.isRemainderAtNote(note.getId(), remainder.getId())) {
            return true;
        }
        return false;
    }

    private Boolean isUserLinkedToNote(Note note, User user) {
        if (noteRepository.isUserAtNote(note.getId(), user.getId())) {
            return true;
        }
        return false;

    }

}
