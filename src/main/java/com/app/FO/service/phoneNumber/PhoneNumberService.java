package com.app.FO.service.phoneNumber;

import com.app.FO.config.DateTime;
import com.app.FO.exceptions.*;
import com.app.FO.model.phoneNumber.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.phoneNumber.PhoneNumberRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PhoneNumberService {
    private PhoneNumberRepository phoneNumberRepository;

    private ServiceAll serviceAll;

    @Autowired
    public PhoneNumberService(PhoneNumberRepository phoneNumberRepository, ServiceAll serviceAll) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public PhoneNumber postPhoneNumber(String subject, String number) {
        User logInUser = serviceAll.getLogInUser();

        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdBySubject(logInUser.getId(), subject);
        if (phoneNumber != null) {
            throw new PhoneNumberAlreadyExistException("PhoneNumber with this subject already exist");
        }

        phoneNumber = phoneNumberRepository.save(new PhoneNumber(subject, number, logInUser));

        PhoneNumberUser phoneNumberUser = new PhoneNumberUser(phoneNumber, logInUser);
        phoneNumber.getPhoneNumberUserList().add(phoneNumberUser);

        return phoneNumberRepository.save(phoneNumber);
    }

    //-- Put
    public PhoneNumber putSubjectToPhoneNumber(Long phoneNumberId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found in your list");
        }

        if (phoneNumber.getSubject().equals(subject)) {
            throw new PhoneNumberAlreadyExistException("PhoneNumber has already the same subject");
        }

        phoneNumber.setSubject(subject);

        return phoneNumberRepository.save(phoneNumber);
    }

    public PhoneNumber putNumberToPhoneNumber(Long phoneNumberId, String number) {
        User logInUser = serviceAll.getLogInUser();
        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found in your list");
        }

        if (phoneNumber.getNumber().equals(number)) {
            throw new PhoneNumberAlreadyExistException("PhoneNumber has already the same number");
        }

        phoneNumber.setNumber(number);

        return phoneNumberRepository.save(phoneNumber);
    }

    public PhoneNumber putUserToPhoneNumber(Long phoneNumberId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        PhoneNumberUser phoneNumberUser = serviceAll.getPhoneNumberUser(phoneNumberId, userId);
        if (phoneNumberUser != null) {
            throw new PhoneNumberUserAlreadyExistException("The phoneNumber already has the user");
        }

        phoneNumberUser = new PhoneNumberUser(phoneNumber, user);
        phoneNumber.getPhoneNumberUserList().add(phoneNumberUser);

        return phoneNumberRepository.save(phoneNumber);
    }

    public PhoneNumber putTagToPhoneNumber(Long phoneNumberId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        PhoneNumberTag phoneNumberTag = serviceAll.getPhoneNumberTag(phoneNumberId, tagId);
        if (phoneNumberTag != null) {
            throw new PhoneNumberTagAlreadyExistException("The phoneNumber already has the tag");
        }

        phoneNumberTag = new PhoneNumberTag(phoneNumber, tag);
        phoneNumber.getPhoneNumberTagList().add(phoneNumberTag);

        return phoneNumberRepository.save(phoneNumber);
    }


    public PhoneNumber putReminderToPhoneNumber(Long phoneNumberId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        PhoneNumberReminder phoneNumberReminder = serviceAll.getPhoneNumberReminder(phoneNumberId, reminderId);
        if (phoneNumberReminder != null) {
            throw new PhoneNumberReminderAlreadyExistException("The phoneNumber already has the reminder");
        }

        phoneNumberReminder = new PhoneNumberReminder(phoneNumber, reminder);
        phoneNumber.getPhoneNumberReminderList().add(phoneNumberReminder);

        return phoneNumberRepository.save(phoneNumber);
    }

    public PhoneNumber putTopicToPhoneNumber(Long phoneNumberId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        PhoneNumberTopic phoneNumberTopic = serviceAll.getPhoneNumberTopic(phoneNumberId, topicId);
        if (phoneNumberTopic != null) {
            throw new PhoneNumberTopicAlreadyExistException("The phoneNumber already has the topic");
        }

        phoneNumberTopic = new PhoneNumberTopic(phoneNumber, topic);
        phoneNumber.getPhoneNumberTopicList().add(phoneNumberTopic);
        return phoneNumberRepository.save(phoneNumber);
    }

    public PhoneNumber putTasksToPhoneNumber(Long phoneNumberId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        PhoneNumberTasks phoneNumberTasks = serviceAll.getPhoneNumberTasks(phoneNumberId, tasksId);
        if (phoneNumberTasks != null) {
            throw new PhoneNumberTasksAlreadyExistException("The phoneNumber already has the tasks");
        }

        phoneNumberTasks = new PhoneNumberTasks(phoneNumber, tasks);
        phoneNumber.getPhoneNumberTasksList().add(phoneNumberTasks);
        return phoneNumberRepository.save(phoneNumber);
    }


    //--Delete


    public PhoneNumber deleteUserFromPhoneNumber(Long phoneNumberId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        PhoneNumberUser phoneNumberUser = serviceAll.getPhoneNumberUser(phoneNumberId, userId);
        if (phoneNumberUser == null) {
            throw new PhoneNumberUserNotFoundException("The phoneNumber don't has the user");
        }
        phoneNumber.getPhoneNumberUserList().remove(phoneNumberUser);

        return phoneNumberRepository.save(phoneNumber);
    }

    public PhoneNumber deleteTagFromPhoneNumber(Long phoneNumberId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        PhoneNumberTag phoneNumberTag = serviceAll.getPhoneNumberTag(phoneNumberId, tagId);
        if (phoneNumberTag == null) {
            throw new PhoneNumberTagNotFoundException("The phoneNumber don't has the tag");
        }

        phoneNumber.getPhoneNumberTagList().remove(phoneNumberTag);

        return phoneNumberRepository.save(phoneNumber);
    }

    public PhoneNumber deleteReminderFromPhoneNumber(Long phoneNumberId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        PhoneNumberReminder phoneNumberReminder = serviceAll.getPhoneNumberReminder(phoneNumberId, reminderId);
        if (phoneNumberReminder == null) {
            throw new PhoneNumberReminderNotFoundException("The phoneNumber don't has the reminder");
        }

        phoneNumber.getPhoneNumberReminderList().remove(phoneNumberReminder);

        return phoneNumberRepository.save(phoneNumber);
    }

    public PhoneNumber deleteTopicFromPhoneNumber(Long phoneNumberId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        PhoneNumberTopic phoneNumberTopic = serviceAll.getPhoneNumberTopic(phoneNumberId, topicId);
        if (phoneNumberTopic == null) {
            throw new PhoneNumberTasksNotFoundException("The phoneNumber don't has the topic");
        }

        phoneNumber.getPhoneNumberTopicList().remove(phoneNumberTopic);

        return phoneNumberRepository.save(phoneNumber);
    }

    public PhoneNumber deleteTasksFromPhoneNumber(Long phoneNumberId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        PhoneNumberTasks phoneNumberTasks = serviceAll.getPhoneNumberTasks(phoneNumberId, tasksId);
        if (phoneNumberTasks == null) {
            throw new PhoneNumberTasksNotFoundException("The phoneNumber don't has the tasks");
        }

        phoneNumber.getPhoneNumberTasksList().remove(phoneNumberTasks);

        return phoneNumberRepository.save(phoneNumber);
    }

    public List<PhoneNumber> deletePhoneNumber(Long phoneNumberId) {
        User logInUser = serviceAll.getLogInUser();

        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found in your list");
        }
        phoneNumberRepository.delete(phoneNumber);
        return getAllPhoneNumber();
    }
    //-- GET


    public List<PhoneNumber> getAllPhoneNumber() {
        User logInUser = serviceAll.getLogInUser();
        List<PhoneNumber> phoneNumberList = phoneNumberRepository.getPhoneNumberListFromUserId(logInUser.getId());
        if (phoneNumberList.isEmpty()) {
            throw new PhoneNumberNotFoundException("No phoneNumber found");
        }
        return phoneNumberList;
    }

    public PhoneNumber getPhoneNumberByPhoneNumberId(Long phoneNumberId) {
        User logInUser = serviceAll.getLogInUser();
        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("No phoneNumber found");
        }
        return phoneNumber;
    }

    public PhoneNumber getPhoneNumberBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdBySubject(logInUser.getId(), subject);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("No phoneNumber found");
        }
        return phoneNumber;
    }

    public List<PhoneNumber> getPhoneNumberListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<PhoneNumber> phoneNumberList = phoneNumberRepository.getPhoneNumberListBySubjectContains(logInUser.getId(), subjectContains);
        if (phoneNumberList.isEmpty()) {
            throw new PhoneNumberNotFoundException("No phoneNumber found");
        }
        return phoneNumberList;
    }

    public PhoneNumber getPhoneNumberByNumber(String number) {
        User logInUser = serviceAll.getLogInUser();
        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByNumber(logInUser.getId(), number);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("No phoneNumber found");
        }
        return phoneNumber;
    }

    public List<PhoneNumber> getPhoneNumberListByNumberContains(String numberContains) {
        User logInUser = serviceAll.getLogInUser();
        List<PhoneNumber> phoneNumberList = phoneNumberRepository.getPhoneNumberListByNumberContains(logInUser.getId(), numberContains);
        if (phoneNumberList.isEmpty()) {
            throw new PhoneNumberNotFoundException("No phoneNumber found");
        }
        return phoneNumberList;
    }

    public PhoneNumber getPhoneNumberByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        PhoneNumber phoneNumber = phoneNumberRepository.getPhoneNumberFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("No phoneNumber found");
        }
        return phoneNumber;
    }

    public List<PhoneNumber> getPhoneNumberListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<PhoneNumber> phoneNumberList = phoneNumberRepository.getPhoneNumberListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (phoneNumberList.isEmpty()) {
            throw new PhoneNumberNotFoundException("No phoneNumber found");
        }
        return phoneNumberList;
    }

    public List<PhoneNumber> getPhoneNumberListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<PhoneNumber> phoneNumberList = phoneNumberRepository.getPhoneNumberListFromUserIdByUserId(logInUser.getId(), userId);
        if (phoneNumberList.isEmpty()) {
            throw new PhoneNumberNotFoundException("No phoneNumber found");
        }
        return phoneNumberList;
    }

    public List<PhoneNumber> getPhoneNumberListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<PhoneNumber> phoneNumberList = phoneNumberRepository.getPhoneNumberListFromUserIdByTagId(logInUser.getId(), tagId);
        if (phoneNumberList.isEmpty()) {
            throw new PhoneNumberNotFoundException("No phoneNumber found");
        }
        return phoneNumberList;
    }

    public List<PhoneNumber> getPhoneNumberListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<PhoneNumber> phoneNumberList = phoneNumberRepository.getPhoneNumberListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (phoneNumberList.isEmpty()) {
            throw new PhoneNumberNotFoundException("No phoneNumber found");
        }
        return phoneNumberList;
    }

    public List<PhoneNumber> getPhoneNumberListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<PhoneNumber> phoneNumberList = phoneNumberRepository.getPhoneNumberListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (phoneNumberList.isEmpty()) {
            throw new PhoneNumberNotFoundException("No phoneNumber found");
        }
        return phoneNumberList;
    }

    public List<PhoneNumber> getPhoneNumberListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<PhoneNumber> phoneNumberList = phoneNumberRepository.getPhoneNumberListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (phoneNumberList.isEmpty()) {
            throw new PhoneNumberNotFoundException("No phoneNumber found");
        }
        return phoneNumberList;
    }

    //-- Other


}
