package com.app.FO.repository.topic;

import com.app.FO.model.topic.TopicReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicReminderRepository extends JpaRepository<TopicReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic_reminder as tr where tr.topic_id=?1 and tr.reminder_id=?2")
    TopicReminder getTopicReminderByTopicIdAndReminderId(Long topicId, Long reminderId);


}
