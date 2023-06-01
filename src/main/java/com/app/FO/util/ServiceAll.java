package com.app.FO.util;

import com.app.FO.model.link.*;
import com.app.FO.model.note.Note;
import com.app.FO.model.person.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.task.*;
import com.app.FO.model.tasks.*;
import com.app.FO.model.topic.*;
import com.app.FO.model.user.Role;
import com.app.FO.model.user.User;
import com.app.FO.model.work.*;
import com.app.FO.repository.link.*;
import com.app.FO.repository.note.NoteRepository;
import com.app.FO.repository.person.*;
import com.app.FO.repository.reminder.ReminderRepository;
import com.app.FO.repository.tag.TagRepository;
import com.app.FO.repository.task.*;
import com.app.FO.repository.tasks.*;
import com.app.FO.repository.topic.*;
import com.app.FO.repository.user.RoleRepository;
import com.app.FO.repository.user.UserRepository;
import com.app.FO.repository.user.UserRoleRepository;
import com.app.FO.repository.work.*;
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
    private TaskRepository taskRepository;
    @Autowired
    private TaskUserRepository taskUserRepository;
    @Autowired
    private TaskTagRepository taskTagRepository;

    @Autowired
    private TaskReminderRepository taskReminderRepository;

    @Autowired
    private TaskTopicRepository taskTopicRepository;

    @Autowired
    private TaskWorkRepository taskWorkRepository;

    @Autowired
    private WorkRepository workRepository;

    @Autowired
    private TasksRepository tasksRepository;
    @Autowired
    private TasksUserRepository tasksUserRepository;
    @Autowired
    private TasksTagRepository tasksTagRepository;

    @Autowired
    private TasksReminderRepository tasksReminderRepository;

    @Autowired
    private TasksTopicRepository tasksTopicRepository;

    @Autowired
    private TasksTaskRepository tasksTaskRepository;

    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private LinkUserRepository linkUserRepository;
    @Autowired
    private LinkTagRepository linkTagRepository;

    @Autowired
    private LinkReminderRepository linkReminderRepository;

    @Autowired
    private LinkTopicRepository linkTopicRepository;

    @Autowired
    private LinkTasksRepository linkTasksRepository;

    @Autowired
    private WorkUserRepository workUserRepository;
    @Autowired
    private WorkTagRepository workTagRepository;

    @Autowired
    private WorkReminderRepository workReminderRepository;

    @Autowired
    private WorkTopicRepository workTopicRepository;


    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonUserRepository personUserRepository;
    @Autowired
    private PersonTagRepository personTagRepository;

    @Autowired
    private PersonReminderRepository personReminderRepository;

    @Autowired
    private PersonTopicRepository personTopicRepository;

    @Autowired
    private PersonTasksRepository personTasksRepository;

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


    //--------------------------

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


    public Task getTaskFromUserIdAndTaskId(Long userId, Long taskId) {
        return taskRepository.getTaskFromUserIdByTaskId(userId, taskId);
    }

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

    public TaskWork getTaskWork(Long taskId, Long topicId) {
        return taskWorkRepository.getTaskWorkByTaskIdAndWorkId(taskId, topicId);
    }

    //-- getTasksAnd

    public Tasks getTasksFromUserIdAndTasksId(Long userId, Long tasksId) {
        return tasksRepository.getTasksFromUserIdByTasksId(userId, tasksId);
    }

    public TasksUser getTasksUser(Long tasksId, Long userId) {
        return tasksUserRepository.getTasksUserByTasksIdAndUserId(tasksId, userId);
    }

    public TasksTag getTasksTag(Long tasksId, Long tagId) {
        return tasksTagRepository.getTasksTagByTasksIdAndTagId(tasksId, tagId);
    }

    public TasksReminder getTasksReminder(Long tasksId, Long reminderId) {
        return tasksReminderRepository.getTasksReminderByTasksIdAndReminderId(tasksId, reminderId);
    }

    public TasksTopic getTasksTopic(Long tasksId, Long topicId) {
        return tasksTopicRepository.getTasksTopicByTasksIdAndTopicId(tasksId, topicId);
    }

    public TasksTask getTasksTask(Long tasksId, Long taskId) {
        return tasksTaskRepository.getTasksTaskByTasksIdAndTaskId(tasksId, taskId);
    }

    //-- getLinkAnd


    public Link getLinkFromUserIdAndLinkId(Long userId, Long linkId) {
        return linkRepository.getLinkFromUserIdByLinkId(userId, linkId);
    }

    public LinkUser getLinkUser(Long linkId, Long userId) {
        return linkUserRepository.getLinkUserByLinkIdAndUserId(linkId, userId);
    }

    public LinkTag getLinkTag(Long linkId, Long tagId) {
        return linkTagRepository.getLinkTagByLinkIdAndTagId(linkId, tagId);
    }

    public LinkReminder getLinkReminder(Long linkId, Long reminderId) {
        return linkReminderRepository.getLinkReminderByLinkIdAndReminderId(linkId, reminderId);
    }

    public LinkTopic getLinkTopic(Long linkId, Long topicId) {
        return linkTopicRepository.getLinkTopicByLinkIdAndTopicId(linkId, topicId);
    }

    public LinkTasks getLinkTasks(Long linkId, Long taskId) {
        return linkTasksRepository.getLinkTasksByLinkIdAndTasksId(linkId, taskId);
    }

//-- getWorkAnd

    public Work getWorkFromUserIdAndWorkId(Long userId, Long workId) {
        return workRepository.getWorkFromUserIdByWorkId(userId, workId);
    }

    public WorkUser getWorkUser(Long workId, Long userId) {
        return workUserRepository.getWorkUserByWorkIdAndUserId(workId, userId);
    }

    public WorkTag getWorkTag(Long workId, Long tagId) {
        return workTagRepository.getWorkTagByWorkIdAndTagId(workId, tagId);
    }

    public WorkReminder getWorkReminder(Long workId, Long reminderId) {
        return workReminderRepository.getWorkReminderByWorkIdAndReminderId(workId, reminderId);
    }

    public WorkTopic getWorkTopic(Long workId, Long topicId) {
        return workTopicRepository.getWorkTopicByWorkIdAndTopicId(workId, topicId);
    }

    //-- getPersonAnd


    public Person getPersonFromUserIdAndPersonId(Long userId, Long personId) {
        return personRepository.getPersonFromUserIdByPersonId(userId, personId);
    }

    public PersonUser getPersonUser(Long personId, Long userId) {
        return personUserRepository.getPersonUserByPersonIdAndUserId(personId, userId);
    }

    public PersonTag getPersonTag(Long personId, Long tagId) {
        return personTagRepository.getPersonTagByPersonIdAndTagId(personId, tagId);
    }

    public PersonReminder getPersonReminder(Long personId, Long reminderId) {
        return personReminderRepository.getPersonReminderByPersonIdAndReminderId(personId, reminderId);
    }

    public PersonTopic getPersonTopic(Long personId, Long topicId) {
        return personTopicRepository.getPersonTopicByPersonIdAndTopicId(personId, topicId);
    }

    public PersonTasks getPersonTasks(Long personId, Long taskId) {
        return personTasksRepository.getPersonTasksByPersonIdAndTasksId(personId, taskId);
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

    public Tag getTagFromUserIdAndTagId(Long userId, Long tagId) {
        return tagRepository.getTagFromUserIdAndTagId(userId, tagId);
    }


    //-- getReminder
    public Reminder getReminderFromUserIdByReminderId(Long userId, Long reminderId) {
        return reminderRepository.getReminderFromUserIdByReminderId(userId, reminderId);
    }

    //-- getNote
    public Note getNoteByIdAndUserId(Long noteId, Long userId) {
        return noteRepository.getNoteByIdAndUserId(noteId, userId);
    }

    //-- getTopic
    public Topic getTopicFromUserIdByTopicId(Long userId, Long topicId) {
        return topicRepository.getTopicFromUserIdByTopicId(userId, topicId);
    }

    //-- getWork

    public Work getWorkByUserIdAndWorkId(Long workId, Long userId) {
        return workRepository.getWorkFromUserIdByWorkId(userId, workId);
    }

    //-- Converter

    public TaskStatus convertTaskStatusTextToTaskStatus(String taskStatusText) {
        TaskStatus taskStatus;
        switch (taskStatusText) {
            case "STARTED":
                taskStatus = TaskStatus.STARTED;
                break;
            case "WORKING":
                taskStatus = TaskStatus.WORKING;
                break;
            case "PENDING":
                taskStatus = TaskStatus.PENDING;
                break;
            case "COMPLITED":
                taskStatus = TaskStatus.COMPLITED;
                break;
            default:
                taskStatus = TaskStatus.UNDEFINE;
                break;

        }
        return taskStatus;
    }

}
