package com.app.FO.repository.link;

import com.app.FO.model.link.LinkTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkTopicRepository extends JpaRepository<LinkTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM link_topic as tt where tt.link_id=?1 and tt.topic_id=?2")
    LinkTopic getLinkTopicByLinkIdAndTopicId(Long linkId, Long topicId);


}
