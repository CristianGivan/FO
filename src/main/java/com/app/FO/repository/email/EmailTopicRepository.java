package com.app.FO.repository.email;

import com.app.FO.model.email.EmailTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTopicRepository extends JpaRepository<EmailTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM email_topic as tt where tt.email_id=?1 and tt.topic_id=?2")
    EmailTopic getEmailTopicByEmailIdAndTopicId(Long emailId, Long topicId);


}
