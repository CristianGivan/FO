package com.app.FO.repository.task;

import com.app.FO.model.task.TaskTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTagRepository extends JpaRepository<TaskTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM task_tag as tt where tt.task_id=?1 and tt.tag_id=?2")
    TaskTag getTaskTagByTaskIdAndTagId(Long taskId, Long tagId);


}
