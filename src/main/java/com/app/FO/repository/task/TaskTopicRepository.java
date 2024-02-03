package com.app.FO.repository.task;

import com.app.FO.model.task.TaskTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTopicRepository extends JpaRepository<TaskTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM task_topic as tt where tt.task_id=?1 and tt.topic_id=?2")
    TaskTopic getTaskTopicByTaskIdAndTopicId(Long taskId, Long topicId);


}
