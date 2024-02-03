package com.app.FO.repository.expenses;

import com.app.FO.model.expenses.ExpensesExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesExpenseRepository extends JpaRepository<ExpensesExpense, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses_expense as tt where tt.expenses_id=?1 and tt.expense_id=?2")
    ExpensesExpense getExpensesExpenseByExpensesIdAndExpenseId(Long expensesId, Long expenseId);


}
