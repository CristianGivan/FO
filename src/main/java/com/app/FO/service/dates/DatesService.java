package com.app.FO.service.dates;

import com.app.FO.config.DateTime;
import com.app.FO.config.ServiceAll;
import com.app.FO.exceptions.*;
import com.app.FO.model.dates.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.dates.DatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DatesService {
    private DatesRepository datesRepository;

    private ServiceAll serviceAll;

    @Autowired
    public DatesService(DatesRepository datesRepository, ServiceAll serviceAll) {
        this.datesRepository = datesRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Dates postDates(String subject, String datesDate) {
        User logInUser = serviceAll.getLogInUser();

        Dates dates = datesRepository.getDatesFromUserIdBySubject(logInUser.getId(), subject);
        if (dates != null) {
            throw new DatesAlreadyExistException("Dates with this subject already exist");
        }

        dates = datesRepository.save(new Dates(subject, datesDate, logInUser));

        DatesUser datesUser = new DatesUser(dates, logInUser);
        dates.getDatesUserList().add(datesUser);

        return datesRepository.save(dates);
    }

    //-- Put
    public Dates putSubjectToDates(Long datesId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found in your list");
        }

        if (dates.getSubject().equals(subject)) {
            throw new DatesAlreadyExistException("Dates has already the same subject");
        }

        dates.setSubject(subject);

        return datesRepository.save(dates);
    }

    public Dates putReferenceToDates(Long datesId, String reference) {
        User logInUser = serviceAll.getLogInUser();
        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found in your list");
        }

        if (dates.getDatesDate().equals(reference)) {
            throw new DatesAlreadyExistException("Dates has already the same reference");
        }

        dates.setDatesDate(reference);

        return datesRepository.save(dates);
    }

    public Dates putUserToDates(Long datesId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        DatesUser datesUser = serviceAll.getDatesUser(datesId, userId);
        if (datesUser != null) {
            throw new DatesUserAlreadyExistException("The dates already has the user");
        }

        datesUser = new DatesUser(dates, user);
        dates.getDatesUserList().add(datesUser);

        return datesRepository.save(dates);
    }

    public Dates putTagToDates(Long datesId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        DatesTag datesTag = serviceAll.getDatesTag(datesId, tagId);
        if (datesTag != null) {
            throw new DatesTagAlreadyExistException("The dates already has the tag");
        }

        datesTag = new DatesTag(dates, tag);
        dates.getDatesTagList().add(datesTag);

        return datesRepository.save(dates);
    }


    public Dates putReminderToDates(Long datesId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        DatesReminder datesReminder = serviceAll.getDatesReminder(datesId, reminderId);
        if (datesReminder != null) {
            throw new DatesReminderAlreadyExistException("The dates already has the reminder");
        }

        datesReminder = new DatesReminder(dates, reminder);
        dates.getDatesReminderList().add(datesReminder);

        return datesRepository.save(dates);
    }

    public Dates putTopicToDates(Long datesId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        DatesTopic datesTopic = serviceAll.getDatesTopic(datesId, topicId);
        if (datesTopic != null) {
            throw new DatesTopicAlreadyExistException("The dates already has the topic");
        }

        datesTopic = new DatesTopic(dates, topic);
        dates.getDatesTopicList().add(datesTopic);
        return datesRepository.save(dates);
    }

    public Dates putTasksToDates(Long datesId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        DatesTasks datesTasks = serviceAll.getDatesTasks(datesId, tasksId);
        if (datesTasks != null) {
            throw new DatesTasksAlreadyExistException("The dates already has the tasks");
        }

        datesTasks = new DatesTasks(dates, tasks);
        dates.getDatesTasksList().add(datesTasks);
        return datesRepository.save(dates);
    }


    //--Delete


    public Dates deleteUserFromDates(Long datesId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        DatesUser datesUser = serviceAll.getDatesUser(datesId, userId);
        if (datesUser == null) {
            throw new DatesUserNotFoundException("The dates don't has the user");
        }
        dates.getDatesUserList().remove(datesUser);

        return datesRepository.save(dates);
    }

    public Dates deleteTagFromDates(Long datesId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        DatesTag datesTag = serviceAll.getDatesTag(datesId, tagId);
        if (datesTag == null) {
            throw new DatesTagNotFoundException("The dates don't has the tag");
        }

        dates.getDatesTagList().remove(datesTag);

        return datesRepository.save(dates);
    }

    public Dates deleteReminderFromDates(Long datesId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        DatesReminder datesReminder = serviceAll.getDatesReminder(datesId, reminderId);
        if (datesReminder == null) {
            throw new DatesReminderNotFoundException("The dates don't has the reminder");
        }

        dates.getDatesReminderList().remove(datesReminder);

        return datesRepository.save(dates);
    }

    public Dates deleteTopicFromDates(Long datesId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        DatesTopic datesTopic = serviceAll.getDatesTopic(datesId, topicId);
        if (datesTopic == null) {
            throw new DatesTasksNotFoundException("The dates don't has the topic");
        }

        dates.getDatesTopicList().remove(datesTopic);

        return datesRepository.save(dates);
    }

    public Dates deleteTasksFromDates(Long datesId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        DatesTasks datesTasks = serviceAll.getDatesTasks(datesId, tasksId);
        if (datesTasks == null) {
            throw new DatesTasksNotFoundException("The dates don't has the tasks");
        }

        dates.getDatesTasksList().remove(datesTasks);

        return datesRepository.save(dates);
    }

    public List<Dates> deleteDates(Long datesId) {
        User logInUser = serviceAll.getLogInUser();

        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found in your list");
        }
        datesRepository.delete(dates);
        return getAllDates();
    }
    //-- GET


    public List<Dates> getAllDates() {
        User logInUser = serviceAll.getLogInUser();
        List<Dates> datesList = datesRepository.getDatesListFromUserId(logInUser.getId());
        if (datesList.isEmpty()) {
            throw new DatesNotFoundException("No dates found");
        }
        return datesList;
    }

    public Dates getDatesByDatesId(Long datesId) {
        User logInUser = serviceAll.getLogInUser();
        Dates dates = datesRepository.getDatesFromUserIdByDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("No dates found");
        }
        return dates;
    }

    public Dates getDatesBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Dates dates = datesRepository.getDatesFromUserIdBySubject(logInUser.getId(), subject);
        if (dates == null) {
            throw new DatesNotFoundException("No dates found");
        }
        return dates;
    }

    public List<Dates> getDatesListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Dates> datesList = datesRepository.getDatesListBySubjectContains(logInUser.getId(), subjectContains);
        if (datesList.isEmpty()) {
            throw new DatesNotFoundException("No dates found");
        }
        return datesList;
    }

    public Dates getDatesByReference(String reference) {
        User logInUser = serviceAll.getLogInUser();
        Dates dates = datesRepository.getDatesFromUserIdByReference(logInUser.getId(), reference);
        if (dates == null) {
            throw new DatesNotFoundException("No dates found");
        }
        return dates;
    }

    public List<Dates> getDatesListByReferenceContains(String referenceContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Dates> datesList = datesRepository.getDatesListByReferenceContains(logInUser.getId(), referenceContains);
        if (datesList.isEmpty()) {
            throw new DatesNotFoundException("No dates found");
        }
        return datesList;
    }

    public Dates getDatesByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Dates dates = datesRepository.getDatesFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (dates == null) {
            throw new DatesNotFoundException("No dates found");
        }
        return dates;
    }

    public List<Dates> getDatesListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Dates> datesList = datesRepository.getDatesListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (datesList.isEmpty()) {
            throw new DatesNotFoundException("No dates found");
        }
        return datesList;
    }

    public List<Dates> getDatesListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Dates> datesList = datesRepository.getDatesListFromUserIdByUserId(logInUser.getId(), userId);
        if (datesList.isEmpty()) {
            throw new DatesNotFoundException("No dates found");
        }
        return datesList;
    }

    public List<Dates> getDatesListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Dates> datesList = datesRepository.getDatesListFromUserIdByTagId(logInUser.getId(), tagId);
        if (datesList.isEmpty()) {
            throw new DatesNotFoundException("No dates found");
        }
        return datesList;
    }

    public List<Dates> getDatesListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Dates> datesList = datesRepository.getDatesListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (datesList.isEmpty()) {
            throw new DatesNotFoundException("No dates found");
        }
        return datesList;
    }

    public List<Dates> getDatesListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Dates> datesList = datesRepository.getDatesListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (datesList.isEmpty()) {
            throw new DatesNotFoundException("No dates found");
        }
        return datesList;
    }

    public List<Dates> getDatesListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Dates> datesList = datesRepository.getDatesListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (datesList.isEmpty()) {
            throw new DatesNotFoundException("No dates found");
        }
        return datesList;
    }

    //-- Other


}
