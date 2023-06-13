package com.app.FO.repository.theDay;

import com.app.FO.model.theDay.TheDayTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TheDayTopicRepository extends JpaRepository<TheDayTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM theDay_topic as tt where tt.theDay_id=?1 and tt.topic_id=?2")
    TheDayTopic getTheDayTopicByTheDayIdAndTopicId(Long theDayId, Long topicId);


}
