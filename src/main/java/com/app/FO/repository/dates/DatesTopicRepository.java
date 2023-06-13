package com.app.FO.repository.dates;

import com.app.FO.model.dates.DatesTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DatesTopicRepository extends JpaRepository<DatesTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates_topic as tt where tt.dates_id=?1 and tt.topic_id=?2")
    DatesTopic getDatesTopicByDatesIdAndTopicId(Long datesId, Long topicId);


}
