package com.app.FO.repository.topic;

import com.app.FO.model.topic.TopicTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicTagRepository extends JpaRepository<TopicTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic_tag as tt where tt.topic_id=?1 and tt.tag_id=?2")
    TopicTag getTopicTagByTopicIdAndTagId(Long topicId, Long tagId);


}
