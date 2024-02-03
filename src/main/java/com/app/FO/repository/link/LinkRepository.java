package com.app.FO.repository.link;

import com.app.FO.model.link.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM link as t inner join link_user tu on t.link_id = tu.link_id where tu.user_id=?1")
    List<Link> getLinkListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM link as t inner join link_user tu on t.link_id = tu.link_id where tu.user_id=?1 and tu.link_id=?2")
    Link getLinkFromUserIdByLinkId(Long userId, Long linkId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM link as t inner join link_user tu on t.link_id = tu.link_id where tu.user_id=?1 and t.subject=?2")
    Link getLinkFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM link as t inner join link_user ut on t.link_id = ut.link_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Link> getLinkListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM link as t inner join link_user tu on t.link_id = tu.link_id where tu.user_id=?1 and t.reference=?2")
    Link getLinkFromUserIdByReference(Long userId, String reference);

    @Query(nativeQuery = true, value =
            "SELECT * FROM link as t inner join link_user ut on t.link_id = ut.link_id where ut.user_id=:userId and t.reference like %:containingText%")
    List<Link> getLinkListByReferenceContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM link as t inner join link_user tu on t.link_id = tu.link_id where tu.user_id=?1 and t.created_date=?2")
    Link getLinkFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM link as t inner join link_user ut on t.link_id = ut.link_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Link> getLinkListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM link as t inner join link_topic as tn on t.link_id = tn.link_id inner join link_user tu on t.link_id = tu.link_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Link> getLinkListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM link as t inner join link_tasks as tn on t.link_id = tn.link_id inner join link_user tu on t.link_id = tu.link_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Link> getLinkListFromUserIdByTasksId(Long userId, Long tasksId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM link as t inner join (SELECT ti.link_id FROM (SELECT t.link_id FROM link as t inner join link_user tu on t.link_id = tu.link_id where tu.user_id=?1) as ti inner join link_user tu on ti.link_id = tu.link_id where tu.user_id=?2)as tr on tr.link_id=t.link_id")
    List<Link> getLinkListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM link as t inner join link_tag as tt on t.link_id = tt.link_id inner join link_user tu on t.link_id = tu.link_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Link> getLinkListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM link as t inner join link_reminder as tr on t.link_id = tr.link_id inner join link_user tu on t.link_id = tu.link_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Link> getLinkListFromUserIdByReminderId(Long userId, Long reminderId);

}
