package com.app.FO.repository.dates;

import com.app.FO.model.dates.DatesReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DatesReminderRepository extends JpaRepository<DatesReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates_reminder as tr where tr.dates_id=?1 and tr.reminder_id=?2")
    DatesReminder getDatesReminderByDatesIdAndReminderId(Long datesId, Long reminderId);


}
