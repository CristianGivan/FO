package com.app.FO.repository.tasks;

import com.app.FO.model.tasks.TasksTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksTagRepository extends JpaRepository<TasksTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks_tag as tt where tt.tasks_id=?1 and tt.tag_id=?2")
    TasksTag getTasksTagByTasksIdAndTagId(Long tasksId, Long tagId);


}
