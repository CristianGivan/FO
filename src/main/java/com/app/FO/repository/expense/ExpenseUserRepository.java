package com.app.FO.repository.expense;

import com.app.FO.model.expense.ExpenseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense_user as tu where tu.expense_id=?1 and tu.user_id=?2")
    ExpenseUser getExpenseUserByExpenseIdAndUserId(Long expenseId, Long userId);


}
