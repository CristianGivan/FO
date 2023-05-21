package com.app.FO.util;

import com.app.FO.model.note.Note;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.Role;
import com.app.FO.model.user.User;
import com.app.FO.repository.note.NoteRepository;
import com.app.FO.repository.tag.TagRepository;
import com.app.FO.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Checks {
    private NoteRepository noteRepository;
    private TagRepository tagRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public Checks(NoteRepository noteRepository, TagRepository tagRepository) {
        this.noteRepository = noteRepository;
        this.tagRepository = tagRepository;
    }

    public Boolean isNote(Note note) {
        if (note == null) {
            return false;
        }
        return true;
    }

    public Boolean isTag(Tag tag) {
        if (tag == null) {
            return false;
        }
        return true;
    }

    public Boolean isTopic(Topic topic) {
        if (topic == null) {
            return false;
        }
        return true;
    }

    public Boolean isReminder(Reminder reminder) {
        if (reminder == null) {
            return false;
        }
        return true;
    }

    public Boolean isUser(User user) {
        if (user == null) {
            return false;
        }
        return true;
    }


    public Boolean isUserTagCreator(User user, Tag tag) {
        if (user.getId() == tag.getCreator().getId()) {
            return true;
        }
        return false;
    }


    public Boolean NoteHasTag(Note note, Tag tag) {
        if (noteRepository.noteIdHasTagId(note.getId(), tag.getId())) {
            return true;
        }
        return false;
    }

    public Boolean noteHasTopic(Note note, Topic topic) {
        if (noteRepository.noteIdHasTopicId(note.getId(), topic.getId())) {
            return true;
        }
        return false;
    }

    public Boolean noteHasReminder(Note note, Reminder reminder) {
        if (noteRepository.noteIdHasReminderId(note.getId(), reminder.getId())) {
            return true;
        }
        return false;
    }

    public Boolean noteHasUser(Note note, User user) {
        if (noteRepository.noteIdHasUserId(note.getId(), user.getId())) {
            return true;
        }
        return false;
    }

    public Boolean tagHasUser(Tag tag, User user) {
        if (tagRepository.tagIdHasUserId(tag.getId(), user.getId())) {
            return true;
        }
        return false;
    }

    public Long userHasRole(User user, Role role) {
        return userRepository.userIdHasRoleId(user.getId(), role.getId());
    }

    public Long userHasUser(User userFrom, User user) {
        return userRepository.userIdHasUserId(userFrom.getId(), user.getId());
    }

    public Boolean userIsAdmin(User user) {
        Boolean isAdminRole = user.getUserRoleList().stream().
                map(userRole -> userRole.getRole().getRoleType().toString()).
                filter(t -> t == "ROLE_ADMIN").findAny().isPresent();
        if (isAdminRole) {
            return true;
        }
        return false;
    }

}
