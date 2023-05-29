package com.app.FO.repository.tasks;

import com.app.FO.model.tasks.TasksReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksReminderRepository extends JpaRepository<TasksReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks_reminder as tr where tr.tasks_id=?1 and tr.reminder_id=?2")
    TasksReminder getTasksReminderByTasksIdAndReminderId(Long tasksId, Long reminderId);


}
