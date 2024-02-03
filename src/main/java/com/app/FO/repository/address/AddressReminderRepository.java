package com.app.FO.repository.address;

import com.app.FO.model.address.AddressReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressReminderRepository extends JpaRepository<AddressReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM address_reminder as tr where tr.address_id=?1 and tr.reminder_id=?2")
    AddressReminder getAddressReminderByAddressIdAndReminderId(Long addressId, Long reminderId);


}
