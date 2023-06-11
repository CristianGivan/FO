package com.app.FO.repository.theDay;

import com.app.FO.model.theDay.TheDayReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TheDayReminderRepository extends JpaRepository<TheDayReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day_reminder as tr where tr.the_day_id=?1 and tr.reminder_id=?2")
    TheDayReminder getTheDayReminderByTheDayIdAndReminderId(Long theDayId, Long reminderId);


}
