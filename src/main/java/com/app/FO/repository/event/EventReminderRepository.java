package com.app.FO.repository.event;

import com.app.FO.model.event.EventReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventReminderRepository extends JpaRepository<EventReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM event_reminder as tr where tr.event_id=?1 and tr.reminder_id=?2")
    EventReminder getEventReminderByEventIdAndReminderId(Long eventId, Long reminderId);


}
