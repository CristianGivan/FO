package com.app.FO.repository.work;

import com.app.FO.model.work.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {


    //    @Query(nativeQuery = true, value =
//            "SELECT * FROM task as t inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1")
//    List<Task> getTaskListFromUserId(Long userId);
//
    @Query(nativeQuery = true, value =
            "SELECT * FROM work as w inner join work_user tw on w.work_id = tw.work_id where tw.user_id=?1 and tw.work_id=?2")
    Work getWorkFromUserIdByWorkId(Long userId, Long workId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM work as w inner join work_user tw on w.work_id = tw.work_id where tw.user_id=?1 and w.subject=?2")
    Work getWorkFromUserIdBySubject(Long userId, String subject);

//    @Query(nativeQuery = true, value =
//            "SELECT * FROM task as t inner join task_user ut on t.task_id = ut.task_id where ut.user_id=:userId and t.subject like %:containingText%")
//    List<Task> getTaskListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM task as t inner join task_topic as tn on t.task_id = tn.task_id inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and tn.topic_id=?2")
//    List<Task> getTaskListFromUserIdByTopicId(Long userId, Long topicId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM task as t inner join task_tag as tt on t.task_id = tt.task_id inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and tt.tag_id=?2")
//    List<Task> getTaskListFromUserIdByTagId(Long userId, Long tagId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM task as t inner join task_reminder as tr on t.task_id = tr.task_id inner join task_user tu on t.task_id = tu.task_id where tu.user_id=?1 and tr.reminder_id=?2")
//    List<Task> getTaskListFromUserIdByReminderId(Long userId, Long reminderId);
}
