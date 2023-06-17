package com.app.FO.repository.reminder;

import com.app.FO.model.reminder.ReminderReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderReminderRepository extends JpaRepository<ReminderReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder_reminder as tu where tu.reminder_id=?1 and tu.reminder_id=?2")
    ReminderReminder getReminderReminderByReminderIdAndReminderId(Long reminderId, Long repeatedReminderId);


}
