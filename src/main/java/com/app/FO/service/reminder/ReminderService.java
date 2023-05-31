package com.app.FO.service.reminder;

import com.app.FO.model.reminder.Reminder;
import com.app.FO.repository.reminder.ReminderRepository;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {
    private ReminderRepository reminderRepository;
    @Autowired
    private UserService userService;

    @Autowired
    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }
    //-- Post

    public Reminder postRemainder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public Reminder postReminderText(String remainderText) {
        return reminderRepository.save(new Reminder(remainderText, userService.getLogInUser()));
    }
    //-- GET

    public List<Reminder> getAllReminder() {
        return reminderRepository.getReminderListByUserId(userService.getLogInUser().getId());
    }

    public Reminder getRemainderById(Long reminderId) {
        return reminderRepository.getReferenceById(reminderId);
    }

    public Reminder getReminderByReminderIdFromUser(Long reminderId) {
        return reminderRepository.getReminderFromUserIdByReminderId(userService.getLogInUser().getId(), reminderId);
    }

    public List<Reminder> getReminderListByNoteId(Long noteId) {
        return reminderRepository.getReminderListByNoteId(noteId);
    }


    //-- Put


    //--Delete

    public void deleteReminder(Reminder reminder) {
        reminderRepository.delete(reminder);
    }

    public void deleteReminderById(Long reminderId) {
        reminderRepository.delete(getRemainderById(reminderId));
    }


    //-- ChecksNote

    public boolean isReminderIdAtNoteId(Long noteId, Long reminderId) {
        return reminderRepository.isReminderAtNote(noteId, reminderId);
    }


    //-- Other


}
