package com.app.FO.service.email;

import com.app.FO.config.DateTime;
import com.app.FO.config.ServiceAll;
import com.app.FO.exceptions.*;
import com.app.FO.model.email.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.email.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailService {
    private EmailRepository emailRepository;

    private ServiceAll serviceAll;

    @Autowired
    public EmailService(EmailRepository emailRepository, ServiceAll serviceAll) {
        this.emailRepository = emailRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Email postEmail(String subject, String emailAddress) {
        User logInUser = serviceAll.getLogInUser();

        Email email = emailRepository.getEmailFromUserIdBySubject(logInUser.getId(), subject);
        if (email != null) {
            throw new EmailAlreadyExistException("Email with this subject already exist");
        }

        email = emailRepository.save(new Email(subject, emailAddress, logInUser));

        EmailUser emailUser = new EmailUser(email, logInUser);
        email.getEmailUserList().add(emailUser);

        return emailRepository.save(email);
    }

    //-- Put
    public Email putSubjectToEmail(Long emailId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found in your list");
        }

        if (email.getSubject().equals(subject)) {
            throw new EmailAlreadyExistException("Email has already the same subject");
        }

        email.setSubject(subject);

        return emailRepository.save(email);
    }

    public Email putEmailAddressToEmail(Long emailId, String emailAddress) {
        User logInUser = serviceAll.getLogInUser();
        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found in your list");
        }

        if (email.getEmailAddress().equals(emailAddress)) {
            throw new EmailAlreadyExistException("Email has already the same emailAddress");
        }

        email.setEmailAddress(emailAddress);

        return emailRepository.save(email);
    }

    public Email putUserToEmail(Long emailId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        EmailUser emailUser = serviceAll.getEmailUser(emailId, userId);
        if (emailUser != null) {
            throw new EmailUserAlreadyExistException("The email already has the user");
        }

        emailUser = new EmailUser(email, user);
        email.getEmailUserList().add(emailUser);

        return emailRepository.save(email);
    }

    public Email putTagToEmail(Long emailId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        EmailTag emailTag = serviceAll.getEmailTag(emailId, tagId);
        if (emailTag != null) {
            throw new EmailTagAlreadyExistException("The email already has the tag");
        }

        emailTag = new EmailTag(email, tag);
        email.getEmailTagList().add(emailTag);

        return emailRepository.save(email);
    }


    public Email putReminderToEmail(Long emailId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        EmailReminder emailReminder = serviceAll.getEmailReminder(emailId, reminderId);
        if (emailReminder != null) {
            throw new EmailReminderAlreadyExistException("The email already has the reminder");
        }

        emailReminder = new EmailReminder(email, reminder);
        email.getEmailReminderList().add(emailReminder);

        return emailRepository.save(email);
    }

    public Email putTopicToEmail(Long emailId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        EmailTopic emailTopic = serviceAll.getEmailTopic(emailId, topicId);
        if (emailTopic != null) {
            throw new EmailTopicAlreadyExistException("The email already has the topic");
        }

        emailTopic = new EmailTopic(email, topic);
        email.getEmailTopicList().add(emailTopic);
        return emailRepository.save(email);
    }

    public Email putTasksToEmail(Long emailId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        EmailTasks emailTasks = serviceAll.getEmailTasks(emailId, tasksId);
        if (emailTasks != null) {
            throw new EmailTasksAlreadyExistException("The email already has the tasks");
        }

        emailTasks = new EmailTasks(email, tasks);
        email.getEmailTasksList().add(emailTasks);
        return emailRepository.save(email);
    }


    //--Delete


    public Email deleteUserFromEmail(Long emailId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        EmailUser emailUser = serviceAll.getEmailUser(emailId, userId);
        if (emailUser == null) {
            throw new EmailUserNotFoundException("The email don't has the user");
        }
        email.getEmailUserList().remove(emailUser);

        return emailRepository.save(email);
    }

    public Email deleteTagFromEmail(Long emailId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        EmailTag emailTag = serviceAll.getEmailTag(emailId, tagId);
        if (emailTag == null) {
            throw new EmailTagNotFoundException("The email don't has the tag");
        }

        email.getEmailTagList().remove(emailTag);

        return emailRepository.save(email);
    }

    public Email deleteReminderFromEmail(Long emailId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        EmailReminder emailReminder = serviceAll.getEmailReminder(emailId, reminderId);
        if (emailReminder == null) {
            throw new EmailReminderNotFoundException("The email don't has the reminder");
        }

        email.getEmailReminderList().remove(emailReminder);

        return emailRepository.save(email);
    }

    public Email deleteTopicFromEmail(Long emailId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        EmailTopic emailTopic = serviceAll.getEmailTopic(emailId, topicId);
        if (emailTopic == null) {
            throw new EmailTasksNotFoundException("The email don't has the topic");
        }

        email.getEmailTopicList().remove(emailTopic);

        return emailRepository.save(email);
    }

    public Email deleteTasksFromEmail(Long emailId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        EmailTasks emailTasks = serviceAll.getEmailTasks(emailId, tasksId);
        if (emailTasks == null) {
            throw new EmailTasksNotFoundException("The email don't has the tasks");
        }

        email.getEmailTasksList().remove(emailTasks);

        return emailRepository.save(email);
    }

    public List<Email> deleteEmail(Long emailId) {
        User logInUser = serviceAll.getLogInUser();

        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found in your list");
        }
        emailRepository.delete(email);
        return getAllEmail();
    }
    //-- GET


    public List<Email> getAllEmail() {
        User logInUser = serviceAll.getLogInUser();
        List<Email> emailList = emailRepository.getEmailListFromUserId(logInUser.getId());
        if (emailList.isEmpty()) {
            throw new EmailNotFoundException("No email found");
        }
        return emailList;
    }

    public Email getEmailByEmailId(Long emailId) {
        User logInUser = serviceAll.getLogInUser();
        Email email = emailRepository.getEmailFromUserIdByEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("No email found");
        }
        return email;
    }

    public Email getEmailBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Email email = emailRepository.getEmailFromUserIdBySubject(logInUser.getId(), subject);
        if (email == null) {
            throw new EmailNotFoundException("No email found");
        }
        return email;
    }

    public List<Email> getEmailListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Email> emailList = emailRepository.getEmailListBySubjectContains(logInUser.getId(), subjectContains);
        if (emailList.isEmpty()) {
            throw new EmailNotFoundException("No email found");
        }
        return emailList;
    }

    public Email getEmailByEmailAddress(String emailAddress) {
        User logInUser = serviceAll.getLogInUser();
        Email email = emailRepository.getEmailFromUserIdByEmailAddress(logInUser.getId(), emailAddress);
        if (email == null) {
            throw new EmailNotFoundException("No email found");
        }
        return email;
    }

    public List<Email> getEmailListByEmailAddressContains(String emailAddressContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Email> emailList = emailRepository.getEmailListByEmailAddressContains(logInUser.getId(), emailAddressContains);
        if (emailList.isEmpty()) {
            throw new EmailNotFoundException("No email found");
        }
        return emailList;
    }

    public Email getEmailByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Email email = emailRepository.getEmailFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (email == null) {
            throw new EmailNotFoundException("No email found");
        }
        return email;
    }

    public List<Email> getEmailListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Email> emailList = emailRepository.getEmailListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (emailList.isEmpty()) {
            throw new EmailNotFoundException("No email found");
        }
        return emailList;
    }

    public List<Email> getEmailListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Email> emailList = emailRepository.getEmailListFromUserIdByUserId(logInUser.getId(), userId);
        if (emailList.isEmpty()) {
            throw new EmailNotFoundException("No email found");
        }
        return emailList;
    }

    public List<Email> getEmailListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Email> emailList = emailRepository.getEmailListFromUserIdByTagId(logInUser.getId(), tagId);
        if (emailList.isEmpty()) {
            throw new EmailNotFoundException("No email found");
        }
        return emailList;
    }

    public List<Email> getEmailListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Email> emailList = emailRepository.getEmailListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (emailList.isEmpty()) {
            throw new EmailNotFoundException("No email found");
        }
        return emailList;
    }

    public List<Email> getEmailListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Email> emailList = emailRepository.getEmailListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (emailList.isEmpty()) {
            throw new EmailNotFoundException("No email found");
        }
        return emailList;
    }

    public List<Email> getEmailListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Email> emailList = emailRepository.getEmailListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (emailList.isEmpty()) {
            throw new EmailNotFoundException("No email found");
        }
        return emailList;
    }

    //-- Other


}
