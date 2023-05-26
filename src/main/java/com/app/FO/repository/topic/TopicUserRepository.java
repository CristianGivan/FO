package com.app.FO.repository.topic;

import com.app.FO.model.topic.TopicUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicUserRepository extends JpaRepository<TopicUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic_user as tu where tu.topic_id=?1 and tu.user_id=?2")
    TopicUser getTopicUserByTopicIdAndUserId(Long topicId, Long userId);


}
