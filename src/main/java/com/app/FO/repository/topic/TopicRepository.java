package com.app.FO.repository.topic;

import com.app.FO.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Long> {

    @Query(nativeQuery = true, value =
            "SELECT * from Topic as t inner join topic_note tn on t.topic_id=tn.topic_id where tn.note_id=?1")
    List<Topic> getTopicsByNoteId(Long noteId);
    @Query(nativeQuery = true, value =
            "SELECT * from Topic as t inner join topic_tag tt on t.topic_id=tt.topic_id where tt.tag_id=?1")
    List<Topic> getTopicListByTagId(Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic as t inner join topic_user ut on t.topic_id = ut.topic_id where ut.user_id=?1 and ut.topic_id=?2")
    Topic getTopicFromUserByTopicId(Long userId, Long topicId);

}
