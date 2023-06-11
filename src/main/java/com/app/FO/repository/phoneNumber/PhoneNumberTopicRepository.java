package com.app.FO.repository.phoneNumber;

import com.app.FO.model.phoneNumber.PhoneNumberTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberTopicRepository extends JpaRepository<PhoneNumberTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber_topic as tt where tt.phoneNumber_id=?1 and tt.topic_id=?2")
    PhoneNumberTopic getPhoneNumberTopicByPhoneNumberIdAndTopicId(Long phoneNumberId, Long topicId);


}
