package com.app.FO.repository.dates;

import com.app.FO.model.dates.Dates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DatesRepository extends JpaRepository<Dates, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM dates as t inner join dates_user tu on t.dates_id = tu.dates_id where tu.user_id=?1")
    List<Dates> getDatesListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates as t inner join dates_user tu on t.dates_id = tu.dates_id where tu.user_id=?1 and tu.dates_id=?2")
    Dates getDatesFromUserIdByDatesId(Long userId, Long datesId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates as t inner join dates_user tu on t.dates_id = tu.dates_id where tu.user_id=?1 and t.subject=?2")
    Dates getDatesFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates as t inner join dates_user ut on t.dates_id = ut.dates_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Dates> getDatesListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM dates as t inner join dates_user tu on t.dates_id = tu.dates_id where tu.user_id=?1 and t.reference=?2")
    Dates getDatesFromUserIdByReference(Long userId, String reference);

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates as t inner join dates_user ut on t.dates_id = ut.dates_id where ut.user_id=:userId and t.reference like %:containingText%")
    List<Dates> getDatesListByReferenceContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates as t inner join dates_user tu on t.dates_id = tu.dates_id where tu.user_id=?1 and t.created_date=?2")
    Dates getDatesFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates as t inner join dates_user ut on t.dates_id = ut.dates_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Dates> getDatesListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates as t inner join dates_topic as tn on t.dates_id = tn.dates_id inner join dates_user tu on t.dates_id = tu.dates_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Dates> getDatesListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates as t inner join dates_tasks as tn on t.dates_id = tn.dates_id inner join dates_user tu on t.dates_id = tu.dates_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Dates> getDatesListFromUserIdByTasksId(Long userId, Long tasksId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates as t inner join (SELECT ti.dates_id FROM (SELECT t.dates_id FROM dates as t inner join dates_user tu on t.dates_id = tu.dates_id where tu.user_id=?1) as ti inner join dates_user tu on ti.dates_id = tu.dates_id where tu.user_id=?2)as tr on tr.dates_id=t.dates_id")
    List<Dates> getDatesListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates as t inner join dates_tag as tt on t.dates_id = tt.dates_id inner join dates_user tu on t.dates_id = tu.dates_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Dates> getDatesListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates as t inner join dates_reminder as tr on t.dates_id = tr.dates_id inner join dates_user tu on t.dates_id = tu.dates_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Dates> getDatesListFromUserIdByReminderId(Long userId, Long reminderId);

}
