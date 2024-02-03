package com.app.FO.repository.tasks;

import com.app.FO.model.tasks.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks as t inner join tasks_user tu on t.tasks_id = tu.tasks_id where tu.user_id=?1")
    List<Tasks> getTasksListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks as t inner join tasks_user tu on t.tasks_id = tu.tasks_id where tu.user_id=?1 and tu.tasks_id=?2")
    Tasks getTasksFromUserIdByTasksId(Long userId, Long tasksId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks as t inner join tasks_user tu on t.tasks_id = tu.tasks_id where tu.user_id=?1 and t.subject=?2")
    Tasks getTasksFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks as t inner join tasks_user ut on t.tasks_id = ut.tasks_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Tasks> getTasksListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks as t inner join tasks_topic as tn on t.tasks_id = tn.tasks_id inner join tasks_user tu on t.tasks_id = tu.tasks_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Tasks> getTasksListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks as t inner join tasks_task as tn on t.tasks_id = tn.tasks_id inner join tasks_user tu on t.tasks_id = tu.tasks_id where tu.user_id=?1 and tn.task_id=?2")
    List<Tasks> getTasksListFromUserIdByTaskId(Long userId, Long taskId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks as t inner join (SELECT ti.tasks_id FROM (SELECT t.tasks_id FROM tasks as t inner join tasks_user tu on t.tasks_id = tu.tasks_id where tu.user_id=?1) as ti inner join tasks_user tu on ti.tasks_id = tu.tasks_id where tu.user_id=?2)as tr on tr.tasks_id=t.tasks_id")
    List<Tasks> getTasksListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks as t inner join tasks_tag as tt on t.tasks_id = tt.tasks_id inner join tasks_user tu on t.tasks_id = tu.tasks_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Tasks> getTasksListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks as t inner join tasks_reminder as tr on t.tasks_id = tr.tasks_id inner join tasks_user tu on t.tasks_id = tu.tasks_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Tasks> getTasksListFromUserIdByReminderId(Long userId, Long reminderId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks as t inner join tasks_user tu on t.tasks_id = tu.tasks_id where tu.user_id=?1 and t.start_date=?2")
    List<Tasks> getTasksListFromUserIdByStartDate(Long userId, LocalDateTime startDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks as t inner join tasks_user tu on t.tasks_id = tu.tasks_id where tu.user_id=?1 and t.end_date=?2")
    List<Tasks> getTasksListFromUserIdByEndDate(Long userId, LocalDateTime endDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks as t inner join tasks_user tu on t.tasks_id = tu.tasks_id where tu.user_id=?1 and t.tasks_status=?2")
    List<Tasks> getTasksListFromUserIdByTasksStatus(Long userId, int tasksStatus);
}
