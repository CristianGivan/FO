package com.app.FO.repository.topic;

import com.app.FO.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * from Topic as t inner join topic_note tn on t.topic_id=tn.topic_id where tn.note_id=?1")
    List<Topic> getTopicsByNoteId(Long noteId);

    @Query(nativeQuery = true, value =
            "SELECT * from Topic as t inner join topic_tag tt on t.topic_id=tt.topic_id where tt.tag_id=?1")
    List<Topic> getTopicListByTagId(Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic as t inner join topic_user tu on t.topic_id = tu.topic_id where tu.user_id=?1 and tu.topic_id=?2")
    Topic getTopicFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic as t inner join topic_user tu on t.topic_id = tu.topic_id where tu.user_id=?1 and t.subject=?2")
    Topic getTopicFromUserIdBySubject(Long userId, String subject);

}
