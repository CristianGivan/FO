package com.app.FO.repository.task;

import com.app.FO.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1")
    List<Task> getTaskListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and tu.task_id=?2")
    Task getTaskFromUserIdByTaskId(Long userId, Long taskId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and t.subject=?2")
    Task getTaskFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_user ut on t.task_id = ut.task_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Task> getTaskListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and t.created_date=?2")
    Task getTaskFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_user ut on t.task_id = ut.task_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Task> getTaskListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_topic as tn on t.task_id = tn.task_id inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Task> getTaskListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_work as tn on t.task_id = tn.task_id inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and tn.work_id=?2")
    List<Task> getTaskListFromUserIdByWorkId(Long userId, Long workId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join (SELECT ti.task_id FROM (SELECT t.task_id FROM task as t inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1) as ti inner join task_user tu on ti.task_id = tu.task_id where tu.user_id=?2)as tr on tr.task_id=t.task_id")
    List<Task> getTaskListFromUserIdByUserId(Long logInUser, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_tag as tt on t.task_id = tt.task_id inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Task> getTaskListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_reminder as tr on t.task_id = tr.task_id inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Task> getTaskListFromUserIdByReminderId(Long userId, Long reminderId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and t.start_date=?2")
    List<Task> getTaskListFromUserIdByStartDate(Long userId, LocalDateTime startDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and t.end_date=?2")
    List<Task> getTaskListFromUserIdByEndDate(Long userId, LocalDateTime endDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and t.task_status=?2")
    List<Task> getTaskListFromUserIdByTaskStatus(Long userId, int taskStatus);
}
