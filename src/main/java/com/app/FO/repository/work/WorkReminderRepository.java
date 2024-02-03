package com.app.FO.repository.work;

import com.app.FO.model.work.WorkReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkReminderRepository extends JpaRepository<WorkReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM work_reminder as tr where tr.work_id=?1 and tr.reminder_id=?2")
    WorkReminder getWorkReminderByWorkIdAndReminderId(Long workId, Long reminderId);


}
