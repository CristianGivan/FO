package com.app.FO.service.reminder;

import com.app.FO.config.DateTime;
import com.app.FO.config.ServiceAll;
import com.app.FO.exceptions.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.reminder.ReminderReminder;
import com.app.FO.model.reminder.ReminderSnooze;
import com.app.FO.model.reminder.ReminderUser;
import com.app.FO.model.snooze.Snooze;
import com.app.FO.model.user.User;
import com.app.FO.repository.reminder.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReminderService {
    private ReminderRepository reminderRepository;

    private ServiceAll serviceAll;

    @Autowired
    public ReminderService(ReminderRepository reminderRepository, ServiceAll serviceAll) {
        this.reminderRepository = reminderRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Reminder postReminder(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Reminder reminder = reminderRepository.getReminderFromUserIdBySubject(logInUser.getId(), subject);
        if (reminder != null) {
            throw new ReminderAlreadyExistException("Reminder with this subject already exist");
        }

        reminder = reminderRepository.save(new Reminder(subject, logInUser));

        ReminderUser reminderUser = new ReminderUser(reminder, logInUser);
        reminder.getReminderUserList().add(reminderUser);

        return reminderRepository.save(reminder);
    }

    //-- Put
    public Reminder putSubjectToReminder(Long reminderId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Reminder reminder = reminderRepository.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found in your list");
        }

        if (reminder.getSubject().equals(subject)) {
            throw new ReminderAlreadyExistException("Reminder has already the same subject");
        }

        reminder.setSubject(subject);

        return reminderRepository.save(reminder);
    }


    public Reminder putReminderDateToReminder(Long reminderId, String reminderDateText) {
/*
Formatter "yyyy-MM-dd HH:mm:ss" 2023.06.01 13:14:15
*/
        LocalDateTime reminderDateTime = DateTime.textToLocalDateTime(reminderDateText);
        User logInUser = serviceAll.getLogInUser();

        Reminder reminder = reminderRepository.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found in your list");
        }

        reminder.setReminderDateTime(reminderDateTime);
        return reminderRepository.save(reminder);
    }


    public Reminder putUserToReminder(Long reminderId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Reminder reminder = reminderRepository.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        ReminderUser reminderUser = serviceAll.getReminderUser(reminderId, userId);
        if (reminderUser != null) {
            throw new ReminderUserAlreadyExistException("The reminder already has the user");
        }

        reminderUser = new ReminderUser(reminder, user);
        reminder.getReminderUserList().add(reminderUser);

        return reminderRepository.save(reminder);
    }

    public Reminder putSnoozeToReminder(Long reminderId, Long snoozeId) {
        User logInUser = serviceAll.getLogInUser();

        Reminder reminder = reminderRepository.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found in your list");
        }

        Snooze snooze = serviceAll.getSnoozeFromUserIdBySnoozeId(logInUser.getId(), snoozeId);
        if (snooze == null) {
            throw new SnoozeNotFoundException("Snooze not found");
        }

        ReminderSnooze reminderSnooze = serviceAll.getReminderSnooze(reminderId, snoozeId);
        if (reminderSnooze != null) {
            throw new ReminderSnoozeAlreadyExistException("The reminder already has the snooze");
        }

        reminderSnooze = new ReminderSnooze(reminder, snooze);
        reminder.getReminderSnoozeList().add(reminderSnooze);
        return reminderRepository.save(reminder);
    }


    public Reminder putReminderToReminder(Long reminderId, Long repeatedReminderId) {
        User logInUser = serviceAll.getLogInUser();

        Reminder reminder = reminderRepository.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found in your list");
        }

        Reminder repeatedReminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), repeatedReminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        ReminderReminder reminderReminder = serviceAll.getReminderReminder(reminderId, repeatedReminderId);
        if (reminderReminder != null) {
            throw new ReminderReminderAlreadyExistException("The reminder already has the reminder");
        }

        reminderReminder = new ReminderReminder(reminder, repeatedReminder);
        reminder.getRepeatedReminderList().add(reminderReminder);
        return reminderRepository.save(reminder);
    }

    //--Delete


    public Reminder deleteUserFromReminder(Long reminderId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Reminder reminder = reminderRepository.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        ReminderUser reminderUser = serviceAll.getReminderUser(reminderId, userId);
        if (reminderUser == null) {
            throw new ReminderUserNotFoundException("The reminder don't has the user");
        }
        reminder.getReminderUserList().remove(reminderUser);

        return reminderRepository.save(reminder);
    }

    public Reminder deleteSnoozeFromReminder(Long reminderId, Long snoozeId) {
        User logInUser = serviceAll.getLogInUser();

        Reminder reminder = reminderRepository.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found in your list");
        }

        Snooze snooze = serviceAll.getSnoozeFromUserIdBySnoozeId(logInUser.getId(), snoozeId);
        if (snooze == null) {
            throw new SnoozeNotFoundException("Snooze not found");
        }

        ReminderSnooze reminderSnooze = serviceAll.getReminderSnooze(reminderId, snoozeId);
        if (reminderSnooze == null) {
            throw new ReminderSnoozeNotFoundException("The reminder don't has the snooze");
        }

        reminder.getReminderSnoozeList().remove(reminderSnooze);

        return reminderRepository.save(reminder);
    }

    public Reminder deleteReminderFromReminder(Long reminderId, Long repeatedReminderId) {
        User logInUser = serviceAll.getLogInUser();

        Reminder reminder = reminderRepository.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found in your list");
        }

        Reminder repeatedReminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), repeatedReminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        ReminderReminder reminderReminder = serviceAll.getReminderReminder(reminderId, repeatedReminderId);
        if (reminderReminder == null) {
            throw new ReminderReminderNotFoundException("The reminder don't has the reminder");
        }

        reminder.getRepeatedReminderList().remove(repeatedReminder);

        return reminderRepository.save(reminder);
    }


    public List<Reminder> deleteReminder(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Reminder reminder = reminderRepository.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found in your list");
        }
        reminderRepository.delete(reminder);
        return getAllReminder();
    }
    //-- GET


    public List<Reminder> getAllReminder() {
        User logInUser = serviceAll.getLogInUser();
        List<Reminder> reminderList = reminderRepository.getReminderListFromUserId(logInUser.getId());
        if (reminderList.isEmpty()) {
            throw new ReminderNotFoundException("No reminder found");
        }
        return reminderList;
    }

    public Reminder getReminderByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        Reminder reminder = reminderRepository.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("No reminder found");
        }
        return reminder;
    }

    public Reminder getReminderBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Reminder reminder = reminderRepository.getReminderFromUserIdBySubject(logInUser.getId(), subject);
        if (reminder == null) {
            throw new ReminderNotFoundException("No reminder found");
        }
        return reminder;
    }

    public List<Reminder> getReminderListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Reminder> reminderList = reminderRepository.getReminderListBySubjectContains(logInUser.getId(), subjectContains);
        if (reminderList.isEmpty()) {
            throw new ReminderNotFoundException("No reminder found");
        }
        return reminderList;
    }


    public Reminder getReminderByReminderDate(String reminderDateText) {
        LocalDateTime reminderDateTime = DateTime.textToLocalDateTime(reminderDateText);
        User logInUser = serviceAll.getLogInUser();
        Reminder reminder = reminderRepository.getReminderFromUserIdByReminderDate(logInUser.getId(), reminderDateTime);
        if (reminder == null) {
            throw new ReminderNotFoundException("No reminder found");
        }
        return reminder;
    }

    public List<Reminder> getReminderListByReminderDateBetween(String reminderDateMin, String reminderDateMax) {
        LocalDateTime reminderDateTimeMin = DateTime.textToLocalDateTime(reminderDateMin);
        LocalDateTime reminderDateTimeMax = DateTime.textToLocalDateTime(reminderDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Reminder> reminderList = reminderRepository.getReminderListFromUserIdByReminderDateBetween(logInUser.getId(), reminderDateTimeMin, reminderDateTimeMax);
        if (reminderList.isEmpty()) {
            throw new ReminderNotFoundException("No reminder found");
        }
        return reminderList;
    }


    public Reminder getReminderByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Reminder reminder = reminderRepository.getReminderFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (reminder == null) {
            throw new ReminderNotFoundException("No reminder found");
        }
        return reminder;
    }

    public List<Reminder> getReminderListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Reminder> reminderList = reminderRepository.getReminderListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (reminderList.isEmpty()) {
            throw new ReminderNotFoundException("No reminder found");
        }
        return reminderList;
    }

    public List<Reminder> getReminderListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Reminder> reminderList = reminderRepository.getReminderListFromUserIdByUserId(logInUser.getId(), userId);
        if (reminderList.isEmpty()) {
            throw new ReminderNotFoundException("No reminder found");
        }
        return reminderList;
    }

    public List<Reminder> getReminderListBySnoozeId(Long snoozeId) {
        User logInUser = serviceAll.getLogInUser();
        List<Reminder> reminderList = reminderRepository.getReminderListFromUserIdBySnoozeId(logInUser.getId(), snoozeId);
        if (reminderList.isEmpty()) {
            throw new ReminderNotFoundException("No reminder found");
        }
        return reminderList;
    }

    public List<Reminder> getReminderListWithReminder(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Reminder> reminderList = reminderRepository.getReminderFromUserIdWithReminderId(logInUser.getId(), reminderId);
        if (reminderList.isEmpty()) {
            throw new ReminderNotFoundException("No reminder found");
        }
        return reminderList;

    }

    public List<Reminder> getReminderListFromReminder(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Reminder> reminderList = reminderRepository.getReminderFromUserIdFromReminderId(logInUser.getId(), reminderId);
        if (reminderList.isEmpty()) {
            throw new ReminderNotFoundException("No reminder found");
        }
        return reminderList;
    }

    //-- Other


}
