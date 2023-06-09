package com.app.FO.repository.document;

import com.app.FO.model.document.DocumentTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTopicRepository extends JpaRepository<DocumentTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM document_topic as tt where tt.document_id=?1 and tt.topic_id=?2")
    DocumentTopic getDocumentTopicByDocumentIdAndTopicId(Long documentId, Long topicId);


}
