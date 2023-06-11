package com.app.FO.repository.email;

import com.app.FO.model.email.EmailReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailReminderRepository extends JpaRepository<EmailReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM email_reminder as tr where tr.email_id=?1 and tr.reminder_id=?2")
    EmailReminder getEmailReminderByEmailIdAndReminderId(Long emailId, Long reminderId);


}
