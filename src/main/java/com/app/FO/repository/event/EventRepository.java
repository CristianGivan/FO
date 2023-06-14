package com.app.FO.repository.event;

import com.app.FO.model.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM event as t inner join event_user tu on t.event_id = tu.event_id where tu.user_id=?1")
    List<Event> getEventListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM event as t inner join event_user tu on t.event_id = tu.event_id where tu.user_id=?1 and tu.event_id=?2")
    Event getEventFromUserIdByEventId(Long userId, Long eventId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM event as t inner join event_user tu on t.event_id = tu.event_id where tu.user_id=?1 and t.subject=?2")
    Event getEventFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM event as t inner join event_user ut on t.event_id = ut.event_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Event> getEventListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM event as t inner join event_user tu on t.event_id = tu.event_id where tu.user_id=?1 and t.created_date=?2")
    Event getEventFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM event as t inner join event_user ut on t.event_id = ut.event_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Event> getEventListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);


    @Query(nativeQuery = true, value =
            "SELECT * FROM event as t inner join (SELECT ti.event_id FROM (SELECT t.event_id FROM event as t inner join event_user tu on t.event_id = tu.event_id where tu.user_id=?1) as ti inner join event_user tu on ti.event_id = tu.event_id where tu.user_id=?2)as tr on tr.event_id=t.event_id")
    List<Event> getEventListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM event as t inner join event_tag as tt on t.event_id = tt.event_id inner join event_user tu on t.event_id = tu.event_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Event> getEventListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM event as t inner join event_reminder as tr on t.event_id = tr.event_id inner join event_user tu on t.event_id = tu.event_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Event> getEventListFromUserIdByReminderId(Long userId, Long reminderId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM event as t inner join event_topic as tn on t.event_id = tn.event_id inner join event_user tu on t.event_id = tu.event_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Event> getEventListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM event as t inner join event_tasks as tn on t.event_id = tn.event_id inner join event_user tu on t.event_id = tu.event_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Event> getEventListFromUserIdByTasksId(Long userId, Long tasksId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM event as t inner join event_expenses as tn on t.event_id = tn.event_id inner join event_user tu on t.event_id = tu.event_id where tu.user_id=?1 and tn.expenses_id=?2")
    List<Event> getEventListFromUserIdByExpensesId(Long userId, Long expensesId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM event as t inner join event_person as tn on t.event_id = tn.event_id inner join event_user tu on t.event_id = tu.event_id where tu.user_id=?1 and tn.person_id=?2")
    List<Event> getEventListFromUserIdByPersonId(Long userId, Long personId);
}
