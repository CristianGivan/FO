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
            "SELECT * FROM work as t inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1 and t.created_date=?2")
    Work getWorkFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_user ut on t.work_id = ut.work_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Work> getWorkListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);


    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1 and t.working_date_time=?2")
    List<Work> getWorkListFromUserIdByWorkingDateTime(Long userId, LocalDateTime workingDateTime);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_user ut on t.work_id = ut.work_id where ut.user_id=?1 and t.working_date_time between ?2 and ?3")
    List<Work> getWorkListFromUserIdByWorkingDateTimeBetween(Long UserId, LocalDateTime workingDateTimeMin, LocalDateTime workingDateTimeMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1 and t.working_time=?2")
    List<Work> getWorkListFromUserIdByWorkingTime(Long userId, Double workingTime);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_user ut on t.work_id = ut.work_id where ut.user_id=?1 and t.working_time between ?2 and ?3")
    List<Work> getWorkListFromUserIdByWorkingTimeBetween(Long UserId, Double workingTimeMin, Double workingTimeMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1 and t.estimated_time=?2")
    List<Work> getWorkFromUserIdByEstimatedTime(Long userId, Double estimatedTime);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_user ut on t.work_id = ut.work_id where ut.user_id=?1 and t.estimated_time between ?2 and ?3")
    List<Work> getWorkListFromUserIdByEstimatedTimeBetween(Long UserId, Double estimatedTimeMin, Double estimatedTimeMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1 and t.working_progress=?2")
    List<Work> getWorkFromUserIdByWorkingProgress(Long userId, Double workingProgress);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as t inner join work_user tu on t.work_id = tu.work_id where tu.user_id=?1 and t.task_status=?2")
    List<Work> getWorkListFromUserIdByTaskStatus(Long userId, int workStatus);

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


}
