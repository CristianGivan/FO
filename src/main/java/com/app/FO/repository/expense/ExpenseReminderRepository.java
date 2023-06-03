package com.app.FO.repository.expense;

import com.app.FO.model.expense.ExpenseReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseReminderRepository extends JpaRepository<ExpenseReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense_reminder as tr where tr.expense_id=?1 and tr.reminder_id=?2")
    ExpenseReminder getExpenseReminderByExpenseIdAndReminderId(Long expenseId, Long reminderId);


}
