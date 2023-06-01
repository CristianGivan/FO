package com.app.FO.repository.person;

import com.app.FO.model.person.PersonReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonReminderRepository extends JpaRepository<PersonReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM person_reminder as tr where tr.person_id=?1 and tr.reminder_id=?2")
    PersonReminder getPersonReminderByPersonIdAndReminderId(Long personId, Long reminderId);


}
