package com.app.FO.repository.expenses;

import com.app.FO.model.expenses.ExpensesTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ExpensesTasksRepository extends JpaRepository<ExpensesTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses_tasks as tt where tt.expenses_id=?1 and tt.tasks_id=?2")
    ExpensesTasks getExpensesTasksByExpensesIdAndTasksId(Long expensesId, Long topicId);


}
