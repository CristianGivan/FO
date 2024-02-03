package com.app.FO.repository.document;

import com.app.FO.model.document.DocumentTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DocumentTasksRepository extends JpaRepository<DocumentTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM document_tasks as tt where tt.document_id=?1 and tt.tasks_id=?2")
    DocumentTasks getDocumentTasksByDocumentIdAndTasksId(Long documentId, Long topicId);


}
