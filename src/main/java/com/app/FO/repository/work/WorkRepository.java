package com.app.FO.repository.work;

import com.app.FO.model.work.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1")
    List<Work> getWorkListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as w inner join work_user tw on w.work_id = tw.work_id where tw.user_id=?1 and tw.work_id=?2")
    Work getWorkFromUserIdByWorkId(Long userId, Long workId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as w inner join work_user tw on w.work_id = tw.work_id where tw.user_id=?1 and w.subject=?2")
    Work getWorkFromUserIdBySubject(Long userId, String subject);


    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_user ut on t.work_id = ut.work_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Work> getWorkListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join (SELECT ti.work_id FROM (SELECT t.work_id FROM work as t inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1) as ti inner join work_user tu on ti.work_id = tu.work_id where tu.user_id=?2)as tr on tr.work_id=t.work_id")
    List<Work> getWorkListFromUserIdByUserId(Long logInUser, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_tag as tt on t.work_id = tt.work_id inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Work> getWorkListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_reminder as tr on t.work_id = tr.work_id inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Work> getWorkListFromUserIdByReminderId(Long userId, Long reminderId);


    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_topic as tn on t.work_id = tn.work_id inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Work> getWorkListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_task as tn on t.work_id = tn.work_id inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1 and tn.task_id=?2")
    List<Work> getWorkListFromUserIdByTaskId(Long userId, Long taskId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1 and t.working_date_time=?2")
    List<Work> getWorkListFromUserIdByWorkingDateTime(Long userId, LocalDateTime workDateTime);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1 and t.working_efort=?2")
    List<Work> getWorkListFromUserIdByWorkingEfort(Long userId, LocalDateTime workEfort);


}
