package com.app.FO.repository.email;

import com.app.FO.model.email.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM email as t inner join email_user tu on t.email_id = tu.email_id where tu.user_id=?1")
    List<Email> getEmailListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM email as t inner join email_user tu on t.email_id = tu.email_id where tu.user_id=?1 and tu.email_id=?2")
    Email getEmailFromUserIdByEmailId(Long userId, Long emailId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM email as t inner join email_user tu on t.email_id = tu.email_id where tu.user_id=?1 and t.subject=?2")
    Email getEmailFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM email as t inner join email_user ut on t.email_id = ut.email_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Email> getEmailListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM email as t inner join email_user tu on t.email_id = tu.email_id where tu.user_id=?1 and t.reference=?2")
    Email getEmailFromUserIdByReference(Long userId, String reference);

    @Query(nativeQuery = true, value =
            "SELECT * FROM email as t inner join email_user ut on t.email_id = ut.email_id where ut.user_id=:userId and t.reference like %:containingText%")
    List<Email> getEmailListByReferenceContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM email as t inner join email_user tu on t.email_id = tu.email_id where tu.user_id=?1 and t.created_date=?2")
    Email getEmailFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM email as t inner join email_user ut on t.email_id = ut.email_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Email> getEmailListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM email as t inner join email_topic as tn on t.email_id = tn.email_id inner join email_user tu on t.email_id = tu.email_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Email> getEmailListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM email as t inner join email_tasks as tn on t.email_id = tn.email_id inner join email_user tu on t.email_id = tu.email_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Email> getEmailListFromUserIdByTasksId(Long userId, Long tasksId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM email as t inner join (SELECT ti.email_id FROM (SELECT t.email_id FROM email as t inner join email_user tu on t.email_id = tu.email_id where tu.user_id=?1) as ti inner join email_user tu on ti.email_id = tu.email_id where tu.user_id=?2)as tr on tr.email_id=t.email_id")
    List<Email> getEmailListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM email as t inner join email_tag as tt on t.email_id = tt.email_id inner join email_user tu on t.email_id = tu.email_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Email> getEmailListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM email as t inner join email_reminder as tr on t.email_id = tr.email_id inner join email_user tu on t.email_id = tu.email_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Email> getEmailListFromUserIdByReminderId(Long userId, Long reminderId);

}
