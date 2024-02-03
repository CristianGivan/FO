package com.app.FO.repository.task;

import com.app.FO.model.task.TaskReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskReminderRepository extends JpaRepository<TaskReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM task_reminder as tr where tr.task_id=?1 and tr.reminder_id=?2")
    TaskReminder getTaskReminderByTaskIdAndReminderId(Long taskId, Long reminderId);


}
