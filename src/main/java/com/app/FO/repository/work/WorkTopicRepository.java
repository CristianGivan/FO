package com.app.FO.repository.work;

import com.app.FO.model.work.WorkTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTopicRepository extends JpaRepository<WorkTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM work_topic as tt where tt.work_id=?1 and tt.topic_id=?2")
    WorkTopic getWorkTopicByWorkIdAndTopicId(Long workId, Long topicId);


}
