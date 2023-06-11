package com.app.FO.service.theDay;

import com.app.FO.config.DateTime;
import com.app.FO.exceptions.TheDayAlreadyExistException;
import com.app.FO.exceptions.TheDayNotFoundException;
import com.app.FO.exceptions.TheDayUserAlreadyExistException;
import com.app.FO.exceptions.UserNotFoundException;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.theDay.*;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.theDay.TheDayRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TheDayService {
    private TheDayRepository theDayRepository;

    private ServiceAll serviceAll;

    @Autowired
    public TheDayService(TheDayRepository theDayRepository, ServiceAll serviceAll) {
        this.theDayRepository = theDayRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public TheDay postTheDay(String subject) {
        User logInUser = serviceAll.getLogInUser();

        TheDay theDay = theDayRepository.getTheDayFromUserIdBySubject(logInUser.getId(), subject);
        if (theDay != null) {
            throw new TheDayAlreadyExistException("TheDay with this subject already exist");
        }

        theDay = theDayRepository.save(new TheDay(subject, logInUser));

        TheDayUser theDayUser = new TheDayUser(theDay, logInUser);
        theDay.getTheDayUserList().add(theDayUser);

        return theDayRepository.save(theDay);
    }

    //-- Put
    public TheDay putSubjectToTheDay(Long theDayId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("TheDay not found in your list");
        }

        if (theDay.getSubject().equals(subject)) {
            throw new TheDayAlreadyExistException("TheDay has already the same subject");
        }

        theDay.setSubject(subject);

        return theDayRepository.save(theDay);
    }

    public TheDay putReferenceToTheDay(Long theDayId, String reference) {
        User logInUser = serviceAll.getLogInUser();
        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("TheDay not found in your list");
        }

        if (theDay.getReference().equals(reference)) {
            throw new TheDayAlreadyExistException("TheDay has already the same reference");
        }

        theDay.setReference(reference);

        return theDayRepository.save(theDay);
    }

    public TheDay putUserToTheDay(Long theDayId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("TheDay not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        TheDayUser theDayUser = serviceAll.getTheDayUser(theDayId, userId);
        if (theDayUser != null) {
            throw new TheDayUserAlreadyExistException("The theDay already has the user");
        }

        theDayUser = new TheDayUser(theDay, user);
        theDay.getTheDayUserList().add(theDayUser);

        return theDayRepository.save(theDay);
    }

    public TheDay putTagToTheDay(Long theDayId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("TheDay not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new com.app.FO.exceptions.TagNotFoundException("Tag not found");
        }

        TheDayTag theDayTag = serviceAll.getTheDayTag(theDayId, tagId);
        if (theDayTag != null) {
            throw new com.app.FO.exceptions.TheDayTagAlreadyExistException("The theDay already has the tag");
        }

        theDayTag = new TheDayTag(theDay, tag);
        theDay.getTheDayTagList().add(theDayTag);

        return theDayRepository.save(theDay);
    }


    public TheDay putReminderToTheDay(Long theDayId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("TheDay not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new com.app.FO.exceptions.ReminderNotFoundException("Reminder not found");
        }

        TheDayReminder theDayReminder = serviceAll.getTheDayReminder(theDayId, reminderId);
        if (theDayReminder != null) {
            throw new com.app.FO.exceptions.TheDayReminderAlreadyExistException("The theDay already has the reminder");
        }

        theDayReminder = new TheDayReminder(theDay, reminder);
        theDay.getTheDayReminderList().add(theDayReminder);

        return theDayRepository.save(theDay);
    }

    public TheDay putTopicToTheDay(Long theDayId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("TheDay not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new com.app.FO.exceptions.TopicNotFoundException("Topic not found");
        }

        TheDayTopic theDayTopic = serviceAll.getTheDayTopic(theDayId, topicId);
        if (theDayTopic != null) {
            throw new com.app.FO.exceptions.TheDayTopicAlreadyExistException("The theDay already has the topic");
        }

        theDayTopic = new TheDayTopic(theDay, topic);
        theDay.getTheDayTopicList().add(theDayTopic);
        return theDayRepository.save(theDay);
    }

    public TheDay putTasksToTheDay(Long theDayId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("TheDay not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new com.app.FO.exceptions.TasksNotFoundException("Tasks not found");
        }

        TheDayTasks theDayTasks = serviceAll.getTheDayTasks(theDayId, tasksId);
        if (theDayTasks != null) {
            throw new com.app.FO.exceptions.TheDayTasksAlreadyExistException("The theDay already has the tasks");
        }

        theDayTasks = new TheDayTasks(theDay, tasks);
        theDay.getTheDayTasksList().add(theDayTasks);
        return theDayRepository.save(theDay);
    }


    //--Delete


    public TheDay deleteUserFromTheDay(Long theDayId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("TheDay not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        TheDayUser theDayUser = serviceAll.getTheDayUser(theDayId, userId);
        if (theDayUser == null) {
            throw new com.app.FO.exceptions.TheDayUserNotFoundException("The theDay don't has the user");
        }
        theDay.getTheDayUserList().remove(theDayUser);

        return theDayRepository.save(theDay);
    }

    public TheDay deleteTagFromTheDay(Long theDayId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("TheDay not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new com.app.FO.exceptions.TagNotFoundException("Tag not found");
        }

        TheDayTag theDayTag = serviceAll.getTheDayTag(theDayId, tagId);
        if (theDayTag == null) {
            throw new com.app.FO.exceptions.TheDayTagNotFoundException("The theDay don't has the tag");
        }

        theDay.getTheDayTagList().remove(theDayTag);

        return theDayRepository.save(theDay);
    }

    public TheDay deleteReminderFromTheDay(Long theDayId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("TheDay not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new com.app.FO.exceptions.ReminderNotFoundException("Reminder not found");
        }

        TheDayReminder theDayReminder = serviceAll.getTheDayReminder(theDayId, reminderId);
        if (theDayReminder == null) {
            throw new com.app.FO.exceptions.TheDayReminderNotFoundException("The theDay don't has the reminder");
        }

        theDay.getTheDayReminderList().remove(theDayReminder);

        return theDayRepository.save(theDay);
    }

    public TheDay deleteTopicFromTheDay(Long theDayId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("TheDay not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new com.app.FO.exceptions.TopicNotFoundException("Topic not found");
        }

        TheDayTopic theDayTopic = serviceAll.getTheDayTopic(theDayId, topicId);
        if (theDayTopic == null) {
            throw new com.app.FO.exceptions.TheDayTasksNotFoundException("The theDay don't has the topic");
        }

        theDay.getTheDayTopicList().remove(theDayTopic);

        return theDayRepository.save(theDay);
    }

    public TheDay deleteTasksFromTheDay(Long theDayId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("TheDay not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new com.app.FO.exceptions.TasksNotFoundException("Tasks not found");
        }

        TheDayTasks theDayTasks = serviceAll.getTheDayTasks(theDayId, tasksId);
        if (theDayTasks == null) {
            throw new com.app.FO.exceptions.TheDayTasksNotFoundException("The theDay don't has the tasks");
        }

        theDay.getTheDayTasksList().remove(theDayTasks);

        return theDayRepository.save(theDay);
    }

    public List<TheDay> deleteTheDay(Long theDayId) {
        User logInUser = serviceAll.getLogInUser();

        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("TheDay not found in your list");
        }
        theDayRepository.delete(theDay);
        return getAllTheDay();
    }
    //-- GET


    public List<TheDay> getAllTheDay() {
        User logInUser = serviceAll.getLogInUser();
        List<TheDay> theDayList = theDayRepository.getTheDayListFromUserId(logInUser.getId());
        if (theDayList.isEmpty()) {
            throw new TheDayNotFoundException("No theDay found");
        }
        return theDayList;
    }

    public TheDay getTheDayByTheDayId(Long theDayId) {
        User logInUser = serviceAll.getLogInUser();
        TheDay theDay = theDayRepository.getTheDayFromUserIdByTheDayId(logInUser.getId(), theDayId);
        if (theDay == null) {
            throw new TheDayNotFoundException("No theDay found");
        }
        return theDay;
    }

    public TheDay getTheDayBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        TheDay theDay = theDayRepository.getTheDayFromUserIdBySubject(logInUser.getId(), subject);
        if (theDay == null) {
            throw new TheDayNotFoundException("No theDay found");
        }
        return theDay;
    }

    public List<TheDay> getTheDayListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<TheDay> theDayList = theDayRepository.getTheDayListBySubjectContains(logInUser.getId(), subjectContains);
        if (theDayList.isEmpty()) {
            throw new TheDayNotFoundException("No theDay found");
        }
        return theDayList;
    }

    public TheDay getTheDayByReference(String reference) {
        User logInUser = serviceAll.getLogInUser();
        TheDay theDay = theDayRepository.getTheDayFromUserIdByReference(logInUser.getId(), reference);
        if (theDay == null) {
            throw new TheDayNotFoundException("No theDay found");
        }
        return theDay;
    }

    public List<TheDay> getTheDayListByReferenceContains(String referenceContains) {
        User logInUser = serviceAll.getLogInUser();
        List<TheDay> theDayList = theDayRepository.getTheDayListByReferenceContains(logInUser.getId(), referenceContains);
        if (theDayList.isEmpty()) {
            throw new TheDayNotFoundException("No theDay found");
        }
        return theDayList;
    }

    public TheDay getTheDayByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        TheDay theDay = theDayRepository.getTheDayFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (theDay == null) {
            throw new TheDayNotFoundException("No theDay found");
        }
        return theDay;
    }

    public List<TheDay> getTheDayListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<TheDay> theDayList = theDayRepository.getTheDayListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (theDayList.isEmpty()) {
            throw new TheDayNotFoundException("No theDay found");
        }
        return theDayList;
    }

    public List<TheDay> getTheDayListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<TheDay> theDayList = theDayRepository.getTheDayListFromUserIdByUserId(logInUser.getId(), userId);
        if (theDayList.isEmpty()) {
            throw new TheDayNotFoundException("No theDay found");
        }
        return theDayList;
    }

    public List<TheDay> getTheDayListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<TheDay> theDayList = theDayRepository.getTheDayListFromUserIdByTagId(logInUser.getId(), tagId);
        if (theDayList.isEmpty()) {
            throw new TheDayNotFoundException("No theDay found");
        }
        return theDayList;
    }

    public List<TheDay> getTheDayListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<TheDay> theDayList = theDayRepository.getTheDayListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (theDayList.isEmpty()) {
            throw new TheDayNotFoundException("No theDay found");
        }
        return theDayList;
    }

    public List<TheDay> getTheDayListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<TheDay> theDayList = theDayRepository.getTheDayListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (theDayList.isEmpty()) {
            throw new TheDayNotFoundException("No theDay found");
        }
        return theDayList;
    }

    public List<TheDay> getTheDayListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<TheDay> theDayList = theDayRepository.getTheDayListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (theDayList.isEmpty()) {
            throw new TheDayNotFoundException("No theDay found");
        }
        return theDayList;
    }

    //-- Other


}
