package com.app.FO.repository.document;

import com.app.FO.model.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM document as t inner join document_user tu on t.document_id = tu.document_id where tu.user_id=?1")
    List<Document> getDocumentListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM document as t inner join document_user tu on t.document_id = tu.document_id where tu.user_id=?1 and tu.document_id=?2")
    Document getDocumentFromUserIdByDocumentId(Long userId, Long documentId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM document as t inner join document_user tu on t.document_id = tu.document_id where tu.user_id=?1 and t.subject=?2")
    Document getDocumentFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM document as t inner join document_user ut on t.document_id = ut.document_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Document> getDocumentListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM document as t inner join document_user tu on t.document_id = tu.document_id where tu.user_id=?1 and t.reference=?2")
    Document getDocumentFromUserIdByReference(Long userId, String reference);

    @Query(nativeQuery = true, value =
            "SELECT * FROM document as t inner join document_user ut on t.document_id = ut.document_id where ut.user_id=:userId and t.reference like %:containingText%")
    List<Document> getDocumentListByReferenceContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM document as t inner join document_user tu on t.document_id = tu.document_id where tu.user_id=?1 and t.created_date=?2")
    Document getDocumentFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM document as t inner join document_user ut on t.document_id = ut.document_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Document> getDocumentListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM document as t inner join document_topic as tn on t.document_id = tn.document_id inner join document_user tu on t.document_id = tu.document_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Document> getDocumentListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM document as t inner join document_tasks as tn on t.document_id = tn.document_id inner join document_user tu on t.document_id = tu.document_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Document> getDocumentListFromUserIdByTasksId(Long userId, Long tasksId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM document as t inner join (SELECT ti.document_id FROM (SELECT t.document_id FROM document as t inner join document_user tu on t.document_id = tu.document_id where tu.user_id=?1) as ti inner join document_user tu on ti.document_id = tu.document_id where tu.user_id=?2)as tr on tr.document_id=t.document_id")
    List<Document> getDocumentListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM document as t inner join document_tag as tt on t.document_id = tt.document_id inner join document_user tu on t.document_id = tu.document_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Document> getDocumentListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM document as t inner join document_reminder as tr on t.document_id = tr.document_id inner join document_user tu on t.document_id = tu.document_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Document> getDocumentListFromUserIdByReminderId(Long userId, Long reminderId);

}
