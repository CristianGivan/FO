package com.app.FO.repository.reminder;

import com.app.FO.model.reminder.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    //-- Create


    //-- Read


    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder as t inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1 and t.reminder_id=?2")
    Reminder getReminderFromUserIdByReminderId(Long UserId, Long reminderId);

    @Query(value = "SELECT * FROM  reminder as r where r.user_id=?1 and r.note_id=?2 and  r.reminder_id=?3"
            , nativeQuery = true)
    default Reminder getReminderFromUserIdByNoteIdAndReminderId(Long userId, Long noteId, Long reminderId) {
        return null;
    }

    @Query(nativeQuery = true, value =
            "SELECT * FROM  reminder as r where r.user_id=?1")
    List<Reminder> getReminderListByUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM  reminder as r where r.note_id=?1")
    List<Reminder> getReminderListByNoteId(Long noteId);

    //-- Update


    //-- Delete


    //-- Check
    @Query(nativeQuery = true, value =
            "SELECT IF(EXISTS(SELECT * FROM  reminder as r where r.note_id=?1 and  r.reminder_id=?2), 'True', 'False')")
    Boolean isReminderAtNote(Long noteId, Long reminderId);

    @Query(nativeQuery = true, value =
            "SELECT IF(EXISTS(SELECT * FROM  reminder as r where r.user_id=?1 and r.note_id=?2 and  r.reminder_id=?3), 'True', 'False')")
    Boolean isReminderAtNoteAndUser(Long userId, Long NoteId, Long reminderId);
}
