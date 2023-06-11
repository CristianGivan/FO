package com.app.FO.repository.theDay;

import com.app.FO.model.theDay.TheDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TheDayRepository extends JpaRepository<TheDay, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day as t inner join the_day_user tu on t.the_day_id = tu.the_day_id where tu.user_id=?1")
    List<TheDay> getTheDayListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day as t inner join the_day_user tu on t.the_day_id = tu.the_day_id where tu.user_id=?1 and tu.the_day_id=?2")
    TheDay getTheDayFromUserIdByTheDayId(Long userId, Long theDayId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day as t inner join the_day_user tu on t.the_day_id = tu.the_day_id where tu.user_id=?1 and t.subject=?2")
    TheDay getTheDayFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day as t inner join the_day_user ut on t.the_day_id = ut.the_day_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<TheDay> getTheDayListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day as t inner join the_day_user tu on t.the_day_id = tu.the_day_id where tu.user_id=?1 and t.day=?2")
    TheDay getTheDayFromUserIdByDay(Long userId, String day);

    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day as t inner join the_day_user ut on t.the_day_id = ut.the_day_id where ut.user_id=:userId and t.day like %:containingText%")
    List<TheDay> getTheDayListByDayContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day as t inner join the_day_user tu on t.the_day_id = tu.the_day_id where tu.user_id=?1 and t.created_date=?2")
    TheDay getTheDayFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day as t inner join the_day_user ut on t.the_day_id = ut.the_day_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<TheDay> getTheDayListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day as t inner join the_day_topic as tn on t.the_day_id = tn.the_day_id inner join the_day_user tu on t.the_day_id = tu.the_day_id where tu.user_id=?1 and tn.topic_id=?2")
    List<TheDay> getTheDayListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day as t inner join the_day_tasks as tn on t.the_day_id = tn.the_day_id inner join the_day_user tu on t.the_day_id = tu.the_day_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<TheDay> getTheDayListFromUserIdByTasksId(Long userId, Long tasksId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day as t inner join (SELECT ti.the_day_id FROM (SELECT t.the_day_id FROM the_day as t inner join the_day_user tu on t.the_day_id = tu.the_day_id where tu.user_id=?1) as ti inner join the_day_user tu on ti.the_day_id = tu.the_day_id where tu.user_id=?2)as tr on tr.the_day_id=t.the_day_id")
    List<TheDay> getTheDayListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day as t inner join the_day_tag as tt on t.the_day_id = tt.the_day_id inner join the_day_user tu on t.the_day_id = tu.the_day_id where tu.user_id=?1 and tt.tag_id=?2")
    List<TheDay> getTheDayListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM the_day as t inner join the_day_reminder as tr on t.the_day_id = tr.the_day_id inner join the_day_user tu on t.the_day_id = tu.the_day_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<TheDay> getTheDayListFromUserIdByReminderId(Long userId, Long reminderId);

}
