package com.app.FO.repository.task;

import com.app.FO.model.task.TaskWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskWorkRepository extends JpaRepository<TaskWork, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM task_work as tw where tw.task_id=?1 and tw.work_id=?2")
    TaskWork getTaskWorkByTaskIdAndWorkId(Long taskId, Long topicId);


}
