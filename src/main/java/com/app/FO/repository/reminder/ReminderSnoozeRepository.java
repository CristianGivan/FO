package com.app.FO.repository.reminder;

import com.app.FO.model.reminder.ReminderSnooze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderSnoozeRepository extends JpaRepository<ReminderSnooze, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder_snooze as tu where tu.reminder_id=?1 and tu.snooze_id=?2")
    ReminderSnooze getReminderSnoozeByReminderIdAndSnoozeId(Long reminderId, Long snoozeId);


}
