package com.app.FO.repository.link;

import com.app.FO.model.link.LinkReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkReminderRepository extends JpaRepository<LinkReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM link_reminder as tr where tr.link_id=?1 and tr.reminder_id=?2")
    LinkReminder getLinkReminderByLinkIdAndReminderId(Long linkId, Long reminderId);


}
