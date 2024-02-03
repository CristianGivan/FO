package com.app.FO.repository.phoneNumber;

import com.app.FO.model.phoneNumber.PhoneNumberReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberReminderRepository extends JpaRepository<PhoneNumberReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber_reminder as tr where tr.phoneNumber_id=?1 and tr.reminder_id=?2")
    PhoneNumberReminder getPhoneNumberReminderByPhoneNumberIdAndReminderId(Long phoneNumberId, Long reminderId);


}
