package com.app.FO.repository.tasks;

import com.app.FO.model.tasks.TasksTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksTopicRepository extends JpaRepository<TasksTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks_topic as tt where tt.tasks_id=?1 and tt.topic_id=?2")
    TasksTopic getTasksTopicByTasksIdAndTopicId(Long tasksId, Long topicId);


}
