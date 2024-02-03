package com.app.FO.repository.document;

import com.app.FO.model.document.DocumentReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentReminderRepository extends JpaRepository<DocumentReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM document_reminder as tr where tr.document_id=?1 and tr.reminder_id=?2")
    DocumentReminder getDocumentReminderByDocumentIdAndReminderId(Long documentId, Long reminderId);


}
