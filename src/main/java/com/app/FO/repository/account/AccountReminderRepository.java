package com.app.FO.repository.account;

import com.app.FO.model.account.AccountReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountReminderRepository extends JpaRepository<AccountReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM account_reminder as tr where tr.account_id=?1 and tr.reminder_id=?2")
    AccountReminder getAccountReminderByAccountIdAndReminderId(Long accountId, Long reminderId);


}
