package com.app.FO.repository.expense;

import com.app.FO.model.expense.ExpenseTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ExpenseTasksRepository extends JpaRepository<ExpenseTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense_tasks as tt where tt.expense_id=?1 and tt.tasks_id=?2")
    ExpenseTasks getExpenseTasksByExpenseIdAndTasksId(Long expenseId, Long topicId);


}
