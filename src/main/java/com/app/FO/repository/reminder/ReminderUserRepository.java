package com.app.FO.repository.reminder;

import com.app.FO.model.reminder.ReminderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderUserRepository extends JpaRepository<ReminderUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder_user as tu where tu.reminder_id=?1 and tu.user_id=?2")
    ReminderUser getReminderUserByReminderIdAndUserId(Long reminderId, Long userId);


}
