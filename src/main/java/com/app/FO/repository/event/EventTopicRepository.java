package com.app.FO.repository.event;

import com.app.FO.model.event.EventTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTopicRepository extends JpaRepository<EventTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM event_topic as tt where tt.event_id=?1 and tt.topic_id=?2")
    EventTopic getEventTopicByEventIdAndTopicId(Long eventId, Long topicId);


}
