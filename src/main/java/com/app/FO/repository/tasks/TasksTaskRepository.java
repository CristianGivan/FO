package com.app.FO.repository.tasks;

import com.app.FO.model.tasks.TasksTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TasksTaskRepository extends JpaRepository<TasksTask, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks_task as tt where tt.tasks_id=?1 and tt.task_id=?2")
    TasksTask getTasksTaskByTasksIdAndTaskId(Long tasksId, Long topicId);


}
