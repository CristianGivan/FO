package com.app.FO.repository.topic;

import com.app.FO.model.topic.TopicLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicLinkRepository extends JpaRepository<TopicLink, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic_link as tt where tt.topic_id=?1 and tt.link_id=?2")
    TopicLink getTopicLinkByTopicIdAndLinkId(Long topicId, Long linkId);


}
