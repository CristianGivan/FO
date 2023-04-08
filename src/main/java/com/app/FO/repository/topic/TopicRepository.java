package com.app.FO.repository.topic;

import com.app.FO.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Long> {

    @Query("SELECT t from Topic as t inner join TopicNote tn on t.id=tn.topic.id " +
            "where tn.note.id=?1")
    List<Topic> getTopicsByNoteId(Long noteId);
    @Query("SELECT t from Topic as t inner join TopicTag tt on t.id=tt.topic.id " +
            "where tt.topic.id=?1")
    List<Topic> getTopicsByTagId(Long topicId);

    @Query(value = "SELECT * FROM topic as t inner join topic_user ut on t.topic_id = ut.topic_id where ut.user_id=?1 and ut.topic_id=?2"
            ,nativeQuery = true)
    Topic getTopicFromUserByTopicId(Long userId, Long topicId);

}