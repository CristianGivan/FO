package com.app.FO.repository.transaction;

import com.app.FO.model.transaction.TransactionReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionReminderRepository extends JpaRepository<TransactionReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction_reminder as tr where tr.transaction_id=?1 and tr.reminder_id=?2")
    TransactionReminder getTransactionReminderByTransactionIdAndReminderId(Long transactionId, Long reminderId);


}
