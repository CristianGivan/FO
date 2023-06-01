package com.app.FO.repository.person;

import com.app.FO.model.person.PersonTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonTopicRepository extends JpaRepository<PersonTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM person_topic as tt where tt.person_id=?1 and tt.topic_id=?2")
    PersonTopic getPersonTopicByPersonIdAndTopicId(Long personId, Long topicId);


}
