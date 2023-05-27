package com.app.FO.util;

import com.app.FO.model.note.Note;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.task.TaskReminder;
import com.app.FO.model.task.TaskTag;
import com.app.FO.model.task.TaskTopic;
import com.app.FO.model.task.TaskUser;
import com.app.FO.model.topic.*;
import com.app.FO.model.user.Role;
import com.app.FO.model.user.User;
import com.app.FO.repository.note.NoteRepository;
import com.app.FO.repository.reminder.ReminderRepository;
import com.app.FO.repository.tag.TagRepository;
import com.app.FO.repository.task.TaskReminderRepository;
import com.app.FO.repository.task.TaskTagRepository;
import com.app.FO.repository.task.TaskTopicRepository;
import com.app.FO.repository.task.TaskUserRepository;
import com.app.FO.repository.topic.*;
import com.app.FO.repository.user.RoleRepository;
import com.app.FO.repository.user.UserRepository;
import com.app.FO.repository.user.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class ServiceAll {
    private NoteRepository noteRepository;
    private TagRepository tagRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private TopicUserRepository topicUserRepository;
    @Autowired
    private TopicTagRepository topicTagRepository;

    @Autowired
    private TopicReminderRepository topicReminderRepository;

    @Autowired
    private TopicNoteRepository topicNoteRepository;

    @Autowired
    private TaskUserRepository taskUserRepository;
    @Autowired
    private TaskTagRepository taskTagRepository;

    @Autowired
    private TaskReminderRepository taskReminderRepository;

    @Autowired
    private TaskTopicRepository taskTopicRepository;

    @Autowired
    public ServiceAll(NoteRepository noteRepository, TagRepository tagRepository) {
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

    public Role userHasRole(User user, Role role) {
        return roleRepository.userIdHasRoleId(role.getId(), user.getId());
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

    //-- getTopicAnd

    public TopicUser getTopicUser(Long topicId, Long userId) {
        return topicUserRepository.getTopicUserByTopicIdAndUserId(topicId, userId);
    }

    public TopicTag getTopicTag(Long topicId, Long tagId) {
        return topicTagRepository.getTopicTagByTopicIdAndTagId(topicId, tagId);
    }

    public TopicNote getTopicNote(Long topicId, Long noteId) {
        return topicNoteRepository.getTopicNoteByTopicIdAndNoteId(topicId, noteId);
    }

    public TopicReminder getTopicReminder(Long topicId, Long reminderId) {
        return topicReminderRepository.getTopicReminderByTopicIdAndReminderId(topicId, reminderId);
    }

    //-- getTaskAnd

    public TaskUser getTaskUser(Long taskId, Long userId) {
        return taskUserRepository.getTaskUserByTaskIdAndUserId(taskId, userId);
    }

    public TaskTag getTaskTag(Long taskId, Long tagId) {
        return taskTagRepository.getTaskTagByTaskIdAndTagId(taskId, tagId);
    }

    public TaskReminder getTaskReminder(Long taskId, Long reminderId) {
        return taskReminderRepository.getTaskReminderByTaskIdAndReminderId(taskId, reminderId);
    }

    public TaskTopic getTaskTopic(Long taskId, Long topicId) {
        return taskTopicRepository.getTaskTopicByTaskIdAndTopicId(taskId, topicId);
    }

    //--------------------------

    //-- getUser

    public User getLogInUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.getUserByUserName(userDetails.getUsername());
    }

    public User getUserByUserId(Long userId) {
        return userRepository.getUserByUserId(userId);
    }

    //-- getTag

    public Tag getTagByUserIdAndTagId(Long tagId, Long userId) {
        return tagRepository.getTagByUserIdAndTagId(tagId, userId);
    }


    //-- getReminder
    public Reminder getReminderByIdAndUserId(Long reminderId, Long userId) {
        return reminderRepository.getReminderByIdAndUserId(reminderId, userId);
    }

    //-- getNote
    public Note getNoteByIdAndUserId(Long noteId, Long userId) {
        return noteRepository.getNoteByIdAndUserId(noteId, userId);
    }

    //-- getTopic
    public Topic getTopicByIdAndUserId(Long topicId, Long userId) {
        return topicRepository.getTopicByIdAndUserId(topicId, userId);
    }

}
