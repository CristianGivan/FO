package com.app.FO.repository.note;

import com.app.FO.model.topic.Topic;
import com.app.FO.model.topic.TopicNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicNoteRepository extends JpaRepository<TopicNote,Long> {

    TopicNote findTopicNoteByNote_IdAndTopic_Id(Long noteId, Long topicId);

}
