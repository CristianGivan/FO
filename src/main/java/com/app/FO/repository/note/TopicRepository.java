package com.app.FO.repository.note;

import com.app.FO.model.note.Topic;
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

}
