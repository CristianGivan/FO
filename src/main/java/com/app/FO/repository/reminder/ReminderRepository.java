package com.app.FO.repository.reminder;

import com.app.FO.model.reminder.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder as t inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1")
    List<Reminder> getReminderListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder as t inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1 and tu.reminder_id=?2")
    Reminder getReminderFromUserIdByReminderId(Long userId, Long reminderId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder as t inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1 and t.subject=?2")
    Reminder getReminderFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder as t inner join reminder_user ut on t.reminder_id = ut.reminder_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Reminder> getReminderListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder as t inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1 and t.reminder_date_time=?2")
    Reminder getReminderFromUserIdByReminderDate(Long userId, LocalDateTime reminderDateTime);

    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder as t inner join reminder_user ut on t.reminder_id = ut.reminder_id where ut.user_id=?1 and t.reminder_date_time between ?2 and ?3")
    List<Reminder> getReminderListFromUserIdByReminderDateBetween(Long UserId, LocalDateTime reminderDateTimeMin, LocalDateTime reminderDateTimeMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder as t inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1 and t.created_date=?2")
    Reminder getReminderFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder as t inner join reminder_user ut on t.reminder_id = ut.reminder_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Reminder> getReminderListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder as t inner join (SELECT ti.reminder_id FROM (SELECT t.reminder_id FROM reminder as t inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1) as ti inner join reminder_user tu on ti.reminder_id = tu.reminder_id where tu.user_id=?2)as tr on tr.reminder_id=t.reminder_id")
    List<Reminder> getReminderListFromUserIdByUserId(Long logInUser, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder as t inner join reminder_snooze as tt on t.reminder_id = tt.reminder_id inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1 and tt.snooze_id=?2")
    List<Reminder> getReminderListFromUserIdBySnoozeId(Long userId, Long snoozeId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder as t inner join reminder_reminder as tt on t.reminder_id = tt.reminder_id inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1 and tt.repeated_reminder_id=?2")
    List<Reminder> getReminderFromUserIdWithReminderId(Long userId, Long reminderId);

    @Query(nativeQuery = true, value =
//          "SELECT * FROM reminder as t inner join reminder_reminder as tt on t.reminder_id = tt.reminder_id inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1 and tt.reminder_id=?2")
            "SELECT * FROM reminder as r inner join (SELECT tt.repeated_reminder_id FROM reminder as t inner join reminder_reminder as tt on t.reminder_id = tt.reminder_id inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1 and tt.reminder_id=?2) as ri where ri.repeated_reminder_id=r.reminder_id")
    List<Reminder> getReminderFromUserIdFromReminderId(Long userId, Long reminderId);

}
