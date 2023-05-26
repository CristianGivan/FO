package com.app.FO.repository.topic;

import com.app.FO.model.topic.TopicNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicNoteRepository extends JpaRepository<TopicNote, Long> {

    TopicNote findTopicNoteByNote_IdAndTopic_Id(Long noteId, Long topicId);//todo -c schimb ordinea la note si topic

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic_note as tn where tn.topic_id=?1 and tn.note_id=?2")
    TopicNote getTopicNoteByTopicIdAndNoteId(Long topicId, Long noteId);


}
