package com.app.FO.repository.expenses;

import com.app.FO.model.expenses.ExpensesReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesReminderRepository extends JpaRepository<ExpensesReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses_reminder as tr where tr.expenses_id=?1 and tr.reminder_id=?2")
    ExpensesReminder getExpensesReminderByExpensesIdAndReminderId(Long expensesId, Long reminderId);


}
