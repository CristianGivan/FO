package com.app.FO.repository.task;

import com.app.FO.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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

//    @Query(nativeQuery = true, value =
//            "SELECT * FROM task as t inner join task_note as tn on t.task_id = tn.task_id inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and tn.note_id=?2")
//    List<Task> getTaskListFromUserIdByNoteId(Long userId, Long noteId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_tag as tt on t.task_id = tt.task_id inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Task> getTaskListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM task as t inner join task_reminder as tr on t.task_id = tr.task_id inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Task> getTaskListFromUserIdByReminderId(Long userId, Long reminderId);
}
